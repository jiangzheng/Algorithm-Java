package string;

import java.util.ArrayList;

public class ReverseVowelsOfAString_E345E {
	/**
	 * Swap vowel characters from two ends.
	 * Time: O(n); Space: O(n)
	 */
	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1) {
			return s;	// invalid input or shortcut
		}
		
		char[] vowels = "aeiouAEIOU".toCharArray();
		ArrayList<Character> vowelList = new ArrayList<Character>();
		for (char x : vowels) {
			vowelList.add(x);
		}
		
		char[] c = s.toCharArray();
		int low = 0, high = s.length() - 1;
		while (low < high) {
			if (!vowelList.contains(c[low])) {
				low++;
				continue;
			}
			if (!vowelList.contains(c[high])) {
				high--;
				continue;
			}
			char temp = c[low];
			c[low++] = c[high];
			c[high--] = temp;
		}
		
		return String.valueOf(c);
	}
	
	public static void main(String[] args) {
		ReverseVowelsOfAString_E345E obj = new ReverseVowelsOfAString_E345E();
		System.out.println(obj.reverseVowels(null));	// null
		System.out.println(obj.reverseVowels(""));	// ""
		System.out.println(obj.reverseVowels("v"));	// v
		
		System.out.println(obj.reverseVowels("hello"));	// holle
		System.out.println(obj.reverseVowels("LEETcode"));	// LeoTcEdE
		System.out.println(obj.reverseVowels("LINTCODe"));	// LeNTCODI
	}
}

/**
 * LeetCode #345
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1: Given s = "hello", return "holle".
 * Example 2: Given s = "leetcode", return "leotcede".
 */

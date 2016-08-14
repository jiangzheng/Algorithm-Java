package string;

public class ReverseString_E344E {
	/**
	 * Swap characters from two ends.
	 * Time: O(n); Space: O(n)
	 */
	public String reverseString1(String s) {
		if (s == null || s.length() <= 1) {
			return s;	// invalid input or shortcut
		}
		
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = temp;
		}
		
		return String.valueOf(c);
	}
	
	/**
	 * Recursion.
	 */
	public String reverseString2(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		
		return reverseString2(s.substring(1)) + s.charAt(0);
	}

	public static void main(String[] args) {
		ReverseString_E344E obj = new ReverseString_E344E();
		System.out.println(obj.reverseString1(null));	// null
		System.out.println(obj.reverseString2(null));	// null
		System.out.println(obj.reverseString1(""));	// ""
		System.out.println(obj.reverseString2(""));	// ""
		System.out.println(obj.reverseString1("v"));	// v
		System.out.println(obj.reverseString2("v"));	// v
		
		System.out.println(obj.reverseString1("hello"));	// olleh
		System.out.println(obj.reverseString2("hello"));	// olleh
		System.out.println(obj.reverseString1("leetcode"));	// edocteel
		System.out.println(obj.reverseString2("leetcode"));	// edocteel
	}
}

/**
 * LeetCode #344
 * Write a function that takes a string as input and returns the string reversed.
 * Example: Given s = "hello", return "olleh"
 */

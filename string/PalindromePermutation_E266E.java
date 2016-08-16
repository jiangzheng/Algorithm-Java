package string;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation_E266E {
	/**
	 * Use boolean array, flip the corresponding bit, no or only 1 true is allowed.
	 * Time: O(n); Space: O(1)
	 */
	public boolean canPermutePalindrome1(String s) {
		if (s == null || s.length() <= 1) {
			return true;	// invalid input and shortcut
		}
		
		boolean[] bits = new boolean[256];	// all false by default
		
		for (int i = 0; i < s.length(); i++) {
			bits[s.charAt(i)] ^= true;	// flip true/false
		}
		
		int trues = 0;
		for (boolean bit : bits) {
			if (bit) {
				trues++;
			}
			if (trues > 1) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Use Map to check the numbers of characters, no or only 1 odd-numbered character is allowed.
	 * Time: O(n); Space: O(n)
	 */
	public boolean canPermutePalindrome2(String s) {
		if (s == null || s.length() <= 1) {
			return true;	// invalid input
		}
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int oddNumbered = 0;
		for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				oddNumbered++;
			}
			if (oddNumbered > 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePermutation_E266E obj = new PalindromePermutation_E266E();
		System.out.println(obj.canPermutePalindrome1(null));	// true
		System.out.println(obj.canPermutePalindrome1(""));	// true
		System.out.println(obj.canPermutePalindrome2(null));	// true
		System.out.println(obj.canPermutePalindrome2(""));	// true
		
		System.out.println(obj.canPermutePalindrome1("aab"));	// true
		System.out.println(obj.canPermutePalindrome1("carerac"));	// true
		System.out.println(obj.canPermutePalindrome2("aab"));	// true
		System.out.println(obj.canPermutePalindrome2("carerac"));	// true

		System.out.println(obj.canPermutePalindrome1("code"));	// false
		System.out.println(obj.canPermutePalindrome1("leetcode"));	// false
		System.out.println(obj.canPermutePalindrome2("code"));	// false
		System.out.println(obj.canPermutePalindrome2("leetcode"));	// false
	}
}

/**
 * LeetCode #266
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 */

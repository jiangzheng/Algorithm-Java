package hashtable;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters_E3M_I384M {
	/**
	 * Hash Table.
	 * Time: O(n); Space: O(1)
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return -1;	// invalid input
		}
		
		int[] charMap = new int[256];	// ASCII
		Arrays.fill(charMap, -1);
		int start = 0, maxLength = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (charMap[s.charAt(i)] >= start) {
				start = charMap[s.charAt(i)] + 1;	// there is a repetition of s.charAt(j) from i to j
			}
			charMap[s.charAt(i)] = i;
			maxLength = Math.max(maxLength, i - start + 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters_E3M_I384M obj = new LongestSubstringWithoutRepeatingCharacters_E3M_I384M();
		System.out.println(obj.lengthOfLongestSubstring(null));	// -1
		System.out.println(obj.lengthOfLongestSubstring(""));	// -1
		
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));	// 3
		System.out.println(obj.lengthOfLongestSubstring("bbbbb"));	// 1
	}
}

/**
 * LeetCode #3
 * LintCode #384
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 *   which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

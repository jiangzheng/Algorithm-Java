package string;

import java.util.Arrays;

public class FirstUniqueCharacterInAString_E387E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;	// invalid input
		}
		
		int[] isUnique = new int[26];
		Arrays.fill(isUnique, 0);
		
		for (int i = 0; i < s.length(); i++) {
			char c = (char) (s.charAt(i) - 'a');
			if (isUnique[c] == 0) {
				isUnique[c] = 1;
			} else if (isUnique[c] == 1) {
				isUnique[c] = 2;
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (isUnique[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		FirstUniqueCharacterInAString_E387E obj = new FirstUniqueCharacterInAString_E387E();
		System.out.println(obj.firstUniqChar(null));	// -2147483648
		System.out.println(obj.firstUniqChar(""));	// -2147483648
		
		System.out.println(obj.firstUniqChar("lintcode"));	// 0
		System.out.println(obj.firstUniqChar("leetcode"));	// 0
		System.out.println(obj.firstUniqChar("loveleetcode"));	// 2		
		System.out.println(obj.firstUniqChar("abcdbdcaadb"));	// -1		
	}
}

/**
 * LeetCode #387
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples: s = "leetcode" return 0.
 * s = "loveleetcode", return 2.
 * Note: You may assume the string contain only lowercase letters.
 */


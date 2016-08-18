package string;

public class LongestPalindromicSubstring_E5M_I200M {
	/**
	 * Two Pointers.
	 * Two cases: the number of characters is either odd or even.
	 * Pick a character, search its two sides
	 * - odd palindrome: expandAroundCenter(s, i, i);
	 * - even palindrome: expandAroundCenter(s, i, i + 1).
	 * Time: O(n^2); Space: O(1) 
	 */
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) {
			return null;	// invalid input
		}
		
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int length1 = expandAroundCenter(s, i, i);
			int length2 = expandAroundCenter(s, i, i + 1);
			int length = Math.max(length1, length2);
			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = i + length / 2 + 1;
			}
		}
		
		return s.substring(start, end);
	}
	
	private int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return (right - 1) - (left + 1) + 1;
	}
  
	public static void main(String[] args) {
		LongestPalindromicSubstring_E5M_I200M obj = new LongestPalindromicSubstring_E5M_I200M();
		System.out.println(obj.longestPalindrome1(null));	// null
		System.out.println(obj.longestPalindrome1(""));	// null

		System.out.println(obj.longestPalindrome1("cacabcbaabb"));	// abcba
	}
}

/**
 * LeetCode #5
 * LintCode #200
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

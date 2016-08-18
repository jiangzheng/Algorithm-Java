package string;

import java.util.Arrays;

public class ImplementStrStr_E28E_I13E {
	/**
	 * Brute Force.
	 * Time: O(mn); Space: O(1)
	 */
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;	// invalid input
		}
		
		int n = haystack.length();
		int m = needle.length();
		
		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Boyer-Moore algorithm.
	 * No backup. Skip as many as m chars when finding one not in pattern.
	 * Two cases:
	 * - if mismatched char not in needle, increment i one char beyond the mismatched char;
	 * - if mismatched char in needle, line up the rightmost same char in needle with the mismatched char.
	 * Time: O(n/m); Space: O(1) 
	 */
	public int strStr2(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;	// invalid input
		}

		int n = haystack.length();
		int m = needle.length();
		
		int[] right = new int[256];	// Boyer-Moore Skip Table for ASCII
		Arrays.fill(right, -1);
		for (int j = 0; j < m; j++) {
			right[needle.charAt(j)] = j;	// right[c] = the rightmost index of c in needle (-1 if c is not in needle).
		}
		
		int skip;
		for (int i = 0; i <= n - m; i += skip) {	// scan haystack forward; From 0 to N - M, i += skip;
			skip = 0;
			for (int j = m - 1; j >= 0; j--) {	// scan needle backward; From M - 1 to 0, j--;
				if (haystack.charAt(i + j) != needle.charAt(j)) {	// if there's a mismatch
					skip = Math.max(1, j - right[haystack.charAt(i + j)]);
					break;
				}
			}
			if (skip == 0) {	// if no mismatch for all j, then the matched substring is found
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		ImplementStrStr_E28E_I13E obj = new ImplementStrStr_E28E_I13E();
		System.out.println(obj.strStr(null, null));	// -1
		System.out.println(obj.strStr(null, "o "));	// -1
		System.out.println(obj.strStr("Hello Hello World", null));	// -1
		System.out.println(obj.strStr("", ""));	// 0
		System.out.println(obj.strStr("", "o "));	// -1
		System.out.println(obj.strStr("Hello Hello World", ""));	// 0
		System.out.println(obj.strStr2(null, null));	// -1
		System.out.println(obj.strStr2(null, "o "));	// -1
		System.out.println(obj.strStr2("Hello Hello World", null));	// -1
		System.out.println(obj.strStr2("", ""));	// 0
		System.out.println(obj.strStr2("", "o "));	// -1
		System.out.println(obj.strStr2("Hello Hello World", ""));	// 0
		
		System.out.println(obj.strStr("Hello Hello World", "o "));	// 4
		System.out.println(obj.strStr2("Hello Hello World", "o "));	// 4
		System.out.println(obj.strStr("Hello Hello World", "ab"));	// -1
		System.out.println(obj.strStr2("Hello Hello World", "ab"));	// -1
	}
}

/**
 * LeetCode #28
 * LintCode #13
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

package string;

public class OneEditDistance_E161M {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		
		int m = s.length(), n = t.length();
		
		if (m > n) {
			return isOneEditDistance(t, s);	// shorter string first
		}
		
		if (n - m > 1) {
			return false;	// if length diff >= 2, return false
		}
		
		int i = 0;
		while (i < m && s.charAt(i) == t.charAt(i)) {	// scan from left to right, find the first diff char
			i++;
		}
		
		if (i == m) {	// if reach the end of the shorter string
			return n - m == 1;	// Append case (if length diff is 1), otherwise append too many chars
		}
		
		if (m == n) {	// Modify case: skip this modified char, and same remaining chars
			i++;
			while (i < m && s.charAt(i) == t.charAt(i)) {
				i++;
			}
		} else {	// if (n - m == 1). Insert case: skip this inserted char, and same remaining chars
			while (i < m && s.charAt(i) == t.charAt(i + 1)) {
				i++;
			}
		}
		
		return i == m;
	}

	public static void main(String[] args) {
		OneEditDistance_E161M obj = new OneEditDistance_E161M();
		System.out.println(obj.isOneEditDistance(null, "abcdeX"));	// false
		System.out.println(obj.isOneEditDistance("abcde", null));	// false
		
		System.out.println(obj.isOneEditDistance("abcde", "abcdeX"));	// true (Append case)
		System.out.println(obj.isOneEditDistance("abcde", "abXde"));	// true (Modify case)
		System.out.println(obj.isOneEditDistance("abcde", "abcXde"));	// true (Insert case)
		System.out.println(obj.isOneEditDistance("abcde", "abcde"));	// false (Same case)
		System.out.println(obj.isOneEditDistance("abcde", "abcdeXy"));	// false (Append too many case)
		System.out.println(obj.isOneEditDistance("abcde", "abXye"));	// false (Modify too many case)
		System.out.println(obj.isOneEditDistance("abcde", "abcXdye"));	// false (Insert too many case)
	}
}

/**
 * LeetCode #161
 * Given two strings S and T, determine if they are both one edit distance apart.
 */

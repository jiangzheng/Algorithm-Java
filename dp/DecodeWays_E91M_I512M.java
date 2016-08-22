package dp;

public class DecodeWays_E91M_I512M {
	/**
	 * 1-d DP.
	 * Let d(i) be the number of decode ways of str[0, i - 1] (0 <= i <= N is the string length).
	 * d(i) = {d(i - 1), if str[i - 1] != 0} + {d(i - 2), if str[i - 1, i - 2] is 1X (X = 1: 9) or 2X (X = 1: 6)}
	 * Initialize: d(0) = 1. 
	 * Return: d(n). 
	 * Time: O(n); Space: O(n) 
	 */
	public int numDecodings1(String s) {
		if (s == null) {
			return -1;	// invalid input
		}
		
		// d(i) = {d(i-1), if s[i-1]!='0'} + {d(i-2), if 1X (X=1..9) or 2X (X=1..6)}
		// d(0) = 0, but set d(0) = 1 for computing d(i);
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		
		int[] d = new int[s.length() + 1];
		d[0] = 1;
		
		for (int i = 1; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {
				d[i] += d[i - 1];
			}
			if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				d[i] += d[i - 2];
			}
		}
		
		return d[s.length()];
	}
	
	/**
	 * 1-d DP.
	 * Use prev represents d(i - 2), curr represents d(i - 1). 
	 * Initialize: d(0) = 0, d(1) = 1.
	 * Return: d(n).
	 * Time: O(n); Space: O(1)
	 */
	public int numDecodings2(String s) {
		if (s == null) {
			return -1;	// invalid input
		}
		
		// d(i) = {d(i-1), if s[i-1]!='0'} + {d(i-2), if 1X (X=1..9) or 2X (X=1..6)}
		// d(0) = 0, d(1) = 1;
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		
		int prev = 0, curr = 1;
		
		for (int i = 1; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '0') {
				curr = 0;
			}
			if (i < 2 || !(s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				prev = 0;
			}
			int temp = prev + curr;
			prev = curr;
			curr = temp;
		}
		
		return curr;
	}
	
	public static void main(String[] args) {
		DecodeWays_E91M_I512M obj = new DecodeWays_E91M_I512M();
		System.out.println(obj.numDecodings1(null));	// -1
		System.out.println(obj.numDecodings2(null));	// -1
		System.out.println(obj.numDecodings1(""));	// 0
		System.out.println(obj.numDecodings2(""));	// 0
		
		System.out.println(obj.numDecodings1("12"));	// 2
		System.out.println(obj.numDecodings2("12"));	// 2
	}
}

/**
 * LeetCode #91
 * LintCode #512
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */

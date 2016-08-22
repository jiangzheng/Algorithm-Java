package dp;

public class DistinctSubsequences_E115H_I118M {
	/**
	 * 2-d DP.
	 * Let d(i, j) be the number of distinct subsequences of T[0, j - 1] in S[0, i - 1].
	 * If S[i - 1] != T[j - 1],  d(i, j) = d(i - 1, j);
	 * If S[i - 1] == T[j - 1],  d(i, j) = d(i - 1, j) + d(i - 1, j - 1).
	 * Initialize: d(i, 0) = 1 (first column), d(0, j) = 0 (first row)
	 * Return d(m, n), where lenS = m, lenT = n.
	 * Time: O(mn); Space: O(mn) 
	 */
	public int numDistinct1(String S, String T) {
		if (S == null || T == null) {
			return -1;	// invalid input
		}
		
		// d(i, j): distinct sequence in s[0..i-1] same as T[0..j-1], i = 0..S, j = 0..T
		// d(i, j) = d(i - 1, j) if s[i - 1] != T[j - 1]
		// d(i, j) = d(i - 1, j) + d(i - 1, j - 1) if s[i - 1] == T[j - 1]
		if (S.length() == 0) {
			return 0;
		}
		
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		
		for (int i = 0; i <= S.length(); i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= Math.min(i, T.length()); j++) {	// skip the case of i < j
			// for (int j = Math.min(i, n); j >= 1; j--) // scan reversely also works
				dp[i][j] = dp[i - 1][j] + ((S.charAt(i - 1) == T.charAt(j - 1)) ? dp[i - 1][j - 1] : 0);
			}
		}
		
		return dp[S.length()][T.length()];
	}
	
	/**
	 * 1-d DP (Rotation array).
	 * Fill up table： j's direction is forward
	 * Time: O(mn); Space: O(n)
	 */
	public int numDistinct2(String S, String T) {
		if (S == null || T == null) {
			return -1;	// invalid input
		}
		
		int[] dp = new int[T.length() + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= S.length(); i++) {
			int prev = dp[0];
			for (int j = 1; j <= Math.min(i, T.length()); j++) {
				int curr = dp[j];
				dp[j] += (S.charAt(i - 1) == T.charAt(j - 1)) ? prev : 0;
				prev = curr;
			}
		}
		
		return dp[T.length()];
	}
	
	/**
	 * 1-d DP (Rotation array).
	 * Fill up table： j's direction is backward
	 * Time: O(mn); Space: O(n)
	 */
	public int numDistinct3(String S, String T) {
		if (S == null || T == null) {
			return -1;	// invalid input
		}
		
		int[] dp = new int[T.length() + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= S.length(); i++) {
			for (int j = Math.min(i, T.length()); j >= 1; j--) {
				dp[j] += (S.charAt(i - 1) == T.charAt(j - 1)) ? dp[j - 1] : 0;
			}
		}
		
		return dp[T.length()];
	}
	
	public static void main(String[] args) {
		DistinctSubsequences_E115H_I118M obj = new DistinctSubsequences_E115H_I118M();
		System.out.println(obj.numDistinct1(null, null));	// -1
		System.out.println(obj.numDistinct2(null, null));	// -1
		System.out.println(obj.numDistinct3(null, null));	// -1
		System.out.println(obj.numDistinct1(null, "rabbit"));	// -1
		System.out.println(obj.numDistinct2(null, "rabbit"));	// -1
		System.out.println(obj.numDistinct3(null, "rabbit"));	// -1
		System.out.println(obj.numDistinct1("rabbbit", null));	// -1
		System.out.println(obj.numDistinct2("rabbbit", null));	// -1
		System.out.println(obj.numDistinct3("rabbbit", null));	// -1
		
		
		System.out.println(obj.numDistinct1("rabbbit","rabbit"));	// 3
		System.out.println(obj.numDistinct2("rabbbit","rabbit"));	// 3
		System.out.println(obj.numDistinct3("rabbbit","rabbit"));	// 3
	}
}

/**
 * LeetCode #115
 * LintCode #118
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string 
 *   by deleting some (can be none) of the characters without disturbing the relative positions 
 *   of the remaining characters. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 */

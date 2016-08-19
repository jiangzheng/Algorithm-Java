package tree;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_E131M_I136M {
	/**
	 * DFS + DP.
	 * DP accelerates DFS, use tab[i][j] to check if it is Palindrome.
	 * Time: O(?); Space: O(n^2)
	 */
	private List<List<String>> listList = new ArrayList<List<String>>();
	
	public List<List<String>> partition(String s) {
		if (s == null || s.length() == 0) {
			return listList;
		}
		
		int n = s.length();
		boolean[][] tab = new boolean[n][n];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				tab[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || tab[i + 1][j - 1]);
			}
		}

		dfsPartition2(s, tab, 0, new ArrayList<String>());
		return listList;
	}
	
	private void dfsPartition2(String s, boolean[][] tab, int start, ArrayList<String> list) {
		if (start == s.length()) {
			listList.add(new ArrayList<String>(list));
		} else {
			for (int i = start; i < s.length(); i++) {
				if (tab[start][i]) {	// use DP to accelerate
					list.add(s.substring(start, i + 1));
					dfsPartition2(s, tab, i + 1, list);
					list.remove(list.size() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PalindromePartitioning_E131M_I136M obj = new PalindromePartitioning_E131M_I136M();
		System.out.println(obj.partition(null));	// []
		System.out.println(obj.partition(""));	// []
		
		System.out.println(obj.partition("aab"));	// [[a, a, b], [aa, b]]
	}
}

/**
 * LeetCode #131
 * LintCode #136
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab", Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
 

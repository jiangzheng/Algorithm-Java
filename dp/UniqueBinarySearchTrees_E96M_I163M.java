package dp;

public class UniqueBinarySearchTrees_E96M_I163M {
	/**
	 * 1-d DP.
	 * d(i): the number of unique BST's of size i.
	 * d(i) = sum{k = 0 ~ i - 1} d(k) * d(i - 1 - k)
	 * Time: O(n^2); Space: O(n)
	 */
	public int numTrees(int n) {
		if (n < 0) {
			return -1;	// invalid input
		}
		
		if (n == 0 || n == 1) {
			return 1;	// d(0) = 1; d(1) = 1;
		}
		
		int[] d = new int[n + 1];	// 0 ~ n
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int k = 0; k < i; k++) {
				d[i] += d[k] * d[i - 1 - k];	// d(i) = \sum_{k = 0}^{i - 1} d(k) d(i - 1 - k)
			}
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees_E96M_I163M obj = new UniqueBinarySearchTrees_E96M_I163M();
		for (int i = -1; i <= 10; i++) {
			System.out.print(obj.numTrees(i) + ", ");	// -1, 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 
		}
	}
}

/**
 * LeetCode #96
 * LintCode #163
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example, Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

/** 
 * d(0) = 1;
 * d(1) = 1;
 * d(2) = d(0) d(1) + d(1) d(0) = 2;
 * d(3) = d(0) d(2) + d(1) d(1) + d(2) d(0) = 5;
 * ...
 * d(i) = \sum_{k = 0}^{i - 1} d(k) d(i - 1 - k)
 * Fill up the table: i from 2 to N, k from 0 to i - 1.
 * Return: d(N).
 */

package dp;

public class MinimumPathSum_E64M_I110E {
	/**
	 * 2-d DP (top-down).
	 * Let d(i, j) be the min path sum from grid[0, 0] (top left) to grid[i, j].
	 * d(i, j) = min{d(i - 1, j), d(i, j - 1)} + grid[i, j];
	 * Return d(m - 1, n - 1).
	 * Time: O(n^2); Space: O(mn)
	 */
	public int minPathSum1(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		// d(i,j) = min{d(i-1,j) if i > 0, d(i,j-1) if j > 0} + g[i,j]
		int m = grid.length;
		int n = grid[0].length;
		int[][] sum = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					sum[i][j] = grid[i][j];
				} else {
					sum[i][j] = Math.min((i > 0) ? sum[i - 1][j] : Integer.MAX_VALUE, 
										 (j > 0) ? sum[i][j - 1] : Integer.MAX_VALUE)
								+ grid[i][j];
				}
			}
		}
		
		return sum[m - 1][n - 1];
	}
	
	/**
	 * 1-d DP (Rotation array).
	 * Time: O(n^2); Space: O(min{m, n}) 
	 */
	public int minPathSum2(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int m = grid.length;
		int n = grid[0].length;
		int min = Math.min(m, n), max = Math.max(m, n);
		
		int[] sum = new int[min];
		int value;
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < min; j++) {
				if (n == min) {
					value = grid[i][j];
				} else {	// m == min
					value = grid[j][i];	// rotate the matrix
				}
				if (i == 0 && j == 0) {
					sum[j] = value;
				} else {
					sum[j] = Math.min((i > 0) ? sum[j] : Integer.MAX_VALUE,
									  (j > 0) ? sum[j - 1] : Integer.MAX_VALUE)
							 + value;
				}
			}
		}
		
		return sum[min - 1];
	}
	
	public static void main(String[] args) {
		MinimumPathSum_E64M_I110E obj = new MinimumPathSum_E64M_I110E();
		System.out.println(obj.minPathSum1(null));	// -2147483648
		System.out.println(obj.minPathSum2(null));	// -2147483648
		System.out.println(obj.minPathSum1(new int[][]{}));	// -2147483648
		System.out.println(obj.minPathSum2(new int[][]{}));	// -2147483648
		
		int[][] a = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		System.out.println(obj.minPathSum1(a));	// 9
		System.out.println(obj.minPathSum2(a));	// 9
	}
}

/**
 * LeetCode #64
 * LintCode #110
 * Given a m x n grid filled with non-negative numbers, 
 *   find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

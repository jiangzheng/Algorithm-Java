package dp;

public class UniquePaths_E62M_I114E {
	/**
	 * 2-d DP.
	 * d(i, j): the number of paths from grid[0, 0] (top-left) to grid[i, j]. 
	 * d(i, j) = d(i - 1, j) {if i > 0} + d(i, j - 1) {if j > 0}
	 * Steps table:
	 *  1	1	1	1	1	1	1
	 *  1	2	3	4	5	6	7
	 *  1	3	6	10	15	21	28
	 * Time: O(m*n); Space: O(m*n)
	 */
	public int uniquePaths1(int m, int n) {
		if (m <= 0 || n <= 0) {
			return 0;	// invalid input
		}
				
		int[][] steps = new int[m][n];
		
		for (int i = 0; i < m; i++) {	// fill up the steps table
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					steps[i][j] = 1;	// mark top-left element to 1
				} else {
					steps[i][j] = 
						((i == 0) ? 0 : steps[i - 1][j]) + 
						((j == 0) ? 0 : steps[i][j - 1]);
				}
			}
		}
		
		return steps[m - 1][n - 1];
	}
	
	/**
	 * 2-d DP.
	 * Only keep the last row or column.
	 * d(j) = d(j) {if i > 0} + d(j - 1) {if j > 0}
	 * Time: O(m*n); Space: O(min{m, n})
	 */
	public int uniquePaths2(int m, int n) {
		if (m <= 0 || n <= 0) {
			return 0;	// invalid input
		}
		
		int min = Math.min(m, n);
		int max = Math.max(m, n);
		int[] steps = new int[min];
		
		for (int i = 0; i < max; i++) {	// fill up the steps row or column
			for (int j = 0; j < min; j++) {
				if (i == 0 && j == 0) {
					steps[j] = 1;	// mark top-left element to 1
				} else {
					steps[j] = 
							((i == 0) ? 0 : steps[j]) + 
							((j == 0) ? 0 : steps[j - 1]);
				}
			}
		}
		
		return steps[min - 1];
	}
	
	public static void main(String[] args) {
		UniquePaths_E62M_I114E obj = new UniquePaths_E62M_I114E();
		System.out.println(obj.uniquePaths1(-1, 2));	// 0
		System.out.println(obj.uniquePaths2(-1, 2));	// 0
		System.out.println(obj.uniquePaths1(2, -1));	// 0
		System.out.println(obj.uniquePaths2(2, -1));	// 0
		System.out.println(obj.uniquePaths1(0, 2));	// 0
		System.out.println(obj.uniquePaths2(0, 2));	// 0
		System.out.println(obj.uniquePaths1(2, 0));	// 0
		System.out.println(obj.uniquePaths2(2, 0));	// 0
		
		System.out.println(obj.uniquePaths1(2, 2));	// 2
		System.out.println(obj.uniquePaths2(2, 2));	// 2
		System.out.println(obj.uniquePaths1(3, 3));	// 6
		System.out.println(obj.uniquePaths2(3, 3));	// 6
		System.out.println(obj.uniquePaths1(10, 10));	// 48620
		System.out.println(obj.uniquePaths2(10, 10));	// 48620
	}
}

/**
 * LeetCode #62
 * LintCode #114
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 */

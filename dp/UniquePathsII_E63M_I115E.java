package dp;

public class UniquePathsII_E63M_I115E {
	/**
	 * 2-d DP.
	 * Similar to UniquePaths_E62M_I114E, set 0 when obstacleGrid[i][j] == 1.
	 * Time: O(m*n); Space: O(m*n)
	 */
	public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;	// invalid input
		}
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] steps = new int[m][n];
		
		for (int i = 0; i < m; i++) {	// fill up the steps table
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					steps[i][j] = (obstacleGrid[i][j] == 1) ? 0 : 1;	// mark top-left element to 1 if no obstacle
				} else {
					steps[i][j] = (obstacleGrid[i][j] == 1) ? 0 : 
									((i == 0) ? 0 : steps[i - 1][j]) + 
									((j == 0) ? 0 : steps[i][j - 1]);
				}
			}
		}
		
		return steps[m - 1][n - 1];
	}
	
	/**
	 * 1-d DP. 
	 * Similar to UniquePaths_E62M_I114E, set 0 when obstacleGrid[i][j] == 1.
	 * Time: O(m*n); Space: O(min{m, n})
	 */
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;	// invalid input
		}
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int min = Math.min(m, n);
		int max = Math.max(m, n);
		int[] steps = new int[min];
		int value;
		
		for (int i = 0; i < max; i++) {	// fill up the steps row or column
			for (int j = 0; j < min; j++) {
				if (n == min) {
					value = obstacleGrid[i][j];
				} else {	// m == min
					value = obstacleGrid[j][i];
				}
				
				if (i == 0 && j == 0) {
					steps[j] = (value == 1) ? 0 : 1;	// mark top-left element to 1 if no obstacle
				} else {
					steps[j] = (value == 1) ? 0 : 
								((i == 0) ? 0 : steps[j]) + 
								((j == 0) ? 0 : steps[j - 1]);
				}
			}
		}
		
		return steps[min - 1];
	}
	
	public static void main(String[] args) {
		UniquePathsII_E63M_I115E obj = new UniquePathsII_E63M_I115E();
		System.out.println(obj.uniquePathsWithObstacles1(null));	// 0
		System.out.println(obj.uniquePathsWithObstacles2(null));	// 0
		System.out.println(obj.uniquePathsWithObstacles1(new int[][]{}));	// 0
		System.out.println(obj.uniquePathsWithObstacles2(new int[][]{}));	// 0
		
		int[][] a = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(obj.uniquePathsWithObstacles1(a));	// 2
		System.out.println(obj.uniquePathsWithObstacles2(a));	// 2
	}
}

/**
 * LeetCode #63
 * LintCode #115
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */

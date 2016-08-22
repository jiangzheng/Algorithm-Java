package dp;

public class MaximalSquare_E221M_I436M {
	/**
	 * 2-d DP.
	 * Time: O(mn); Space: O(mn) 
	 */
	public int maximalSquare1(char[][] matrix) {
		if (matrix == null) {
			return -1;	// invalid input
		}
		
		if (matrix.length == 0)
			return 0;
		
		int[][] d = new int[matrix.length][matrix[0].length];
		int max = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					d[i][j] = 0;
				} else {	// if  (matrix[i][j] == '1')
					if (i == 0 || j == 0) {
						d[i][j] = 1;
					} else {
						d[i][j] = Math.min(Math.min(d[i - 1][j - 1], d[i - 1][j]), d[i][j - 1]) + 1;
					}
				}
				max = Math.max(max, d[i][j]);
			}
		}
		
		return max * max;
	}
	
	/**
	 * 1-d DP (Rotation array).
	 * Time: O(mn), Space: O(min{m, n})
	 */
	public int maximalSquare2(char[][] matrix) {
		if (matrix == null) {
			return -1;	// invalid input
		}
		
		if (matrix.length == 0) {
			return 0;
		}

		int[] d = new int[Math.min(matrix.length, matrix[0].length)];
		int max = 0, prev = d[0], curr = d[0];
		
		for (int i = 0; i < Math.max(matrix.length, matrix[0].length); i++) {
			for (int j = 0; j < Math.min(matrix.length, matrix[0].length); j++) {
				curr = d[j];
				int entry = matrix.length > matrix[0].length ? matrix[i][j] : matrix[j][i];
				if (entry == '0') {
					d[j] = 0;
				} else {	// if  (entry == '1')
					if (i == 0 || j == 0) {
						d[j] = 1;
					} else {
						d[j] = Math.min(Math.min(prev, d[j]), d[j - 1]) + 1;
					}
				}
				prev = curr;
				max = Math.max(max, d[j]);
			}
		}
		
		return max * max;
	}
	
	public static void main(String[] args) {
		MaximalSquare_E221M_I436M obj = new MaximalSquare_E221M_I436M();
		System.out.println(obj.maximalSquare1(null));	// -1
		System.out.println(obj.maximalSquare2(null));	// 0
		System.out.println(obj.maximalSquare1(new char[][]{}));	// -1
		System.out.println(obj.maximalSquare2(new char[][]{}));	// 0
		
		char[][] a = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
		System.out.println(obj.maximalSquare1(a));	// 4
		System.out.println(obj.maximalSquare2(a));	// 4
	}
}

/**
 * LeetCode #221
 * LintCode #436
 * Given a 2D binary matrix filled with 0's and 1's, 
 *   find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */

package array;

public class SetMatrixZeroes_E73M_I162M {
	/**
	 * O(mn): new matrix
	 * O(m+n): two arrays storing first row and first column 
	 * Time: O(mn), Space: O(1)
	 */
	public int[][] setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return null;	// invalid input
		}
		
		int m = matrix.length, n = matrix[0].length;
		boolean isFirstRowZero = false, isFirstColZero = false;	// two indicators
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						isFirstRowZero = true;
					}
					if (j == 0) {
						isFirstColZero = true;
					}
					matrix[i][0] = 0;	// mark the row (the first element in the same row)
					matrix[0][j] = 0;	// mark the col (the same element in the first row)
				}
			}
		}
		
		// zero rows (except the first row) according to the first column
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// zero columns (except the first col) according to the first row
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// zero first row if needed
		if (isFirstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		
		// zero first col if needed
		if (isFirstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		SetMatrixZeroes_E73M_I162M obj = new SetMatrixZeroes_E73M_I162M();
		System.out.println(obj.setZeroes(null));	// null
		System.out.println(obj.setZeroes(new int[][]{}));	// null
		
		int[][] a = {{1, 2, 3, 0, 5}, {6, 7, 8, 9, 10}, {0, 12, 0, 14, 15}, {16, 17, 18, 19, 20}};
		int[][] result = obj.setZeroes(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.print("]\n");
		}
		/**
		 * [ 0 0 0 0 0 ]
		 * [ 0 7 0 0 10 ]
		 * [ 0 0 0 0 0 ]
		 * [ 0 17 0 0 20 ]
		 */
	}
}

/**
 * LeetCode #73
 * LintCode #162
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up: Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

package array;

public class MatrixZigzagTraversal_I185E {
	/**
	 * Time: O(mn); Space: O(mn)
	 */
	public int[] printZMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return null;	// invalid input
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[] result = new int[row * col];
		
		if (matrix.length == 1) {
			return matrix[0];	// shortcut
		}
		
		int i = 0, j = 0, pointer = 0;
		result[pointer++] = matrix[i][j];
		
		while (pointer < result.length) {
			// move right 1 step, or down
			if (j + 1 < col || i + 1 < row) {
				if (j + 1 < col) {
					j++;
				} else if (i + 1 < row) {
					i++;
				}
				result[pointer++] = matrix[i][j];
			}
			
			// move left-bottom
			while (j - 1 >= 0 && i + 1 < row) {
				result[pointer++] = matrix[++i][--j];
			}
			
			// move down, or right
			if (j + 1 < col || i + 1 < row) {
				if (i + 1 < row) {
					i++;
				} else if (j + 1 < col) {
					j++;
				}
				result[pointer++] = matrix[i][j];
			} 
			
			// move right-up
			while (j + 1 < col && i - 1 >= 0) {
				result[pointer++] = matrix[--i][++j];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MatrixZigzagTraversal_I185E obj = new MatrixZigzagTraversal_I185E();
		System.out.println(obj.printZMatrix(null));	// null
		System.out.println(obj.printZMatrix(new int[][]{}));	// null
		
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[] result = obj.printZMatrix(matrix);
		for (int x : result) {
			System.out.print(x + ", ");	// 1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12, 
		}
	}
}

/**
 * LintCode #185
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.
 * Example: Given a matrix:
 * [
 *   [1, 2,  3,  4],
 *   [5, 6,  7,  8],
 *   [9,10, 11, 12]
 * ]
 * return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
 */

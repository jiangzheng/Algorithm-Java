package array;

public class SpiralMatrixII_E59M_I381M {
	/**
	 * Time: O(n^2), Space: O(n^2)
	 */
	public int[][] generateMatrix(int n) {
		int[][] m = new int[n][n];
		if (n <= 0) {
			return m;	// invalid input
		}
		
		int number = 1, row = n, col = n;
		int i = 0, j = -1;
		
		while (true) {
			for (int k = 0; k < col; k++) {
				m[i][++j] = number++;	// go right
			}
			if (--row == 0) {
				break;
			}
			for (int k = 0; k < row; k++) {
				m[++i][j] = number++;	// go down
			}
			if (--col == 0) {
				break;
			}
			for (int k = 0; k < col; k++) {
				m[i][--j] = number++;	// go left
			}
			if (--row == 0) {
				break;
			}
			for (int k = 0; k < row; k++) {
				m[--i][j] = number++;	// go up
			}
			if (--col == 0) {
				break;
			}
		}
		
		return m;
	}
	
	public static void main(String[] args) {
		SpiralMatrixII_E59M_I381M obj = new SpiralMatrixII_E59M_I381M();
		
		int[][] a = obj.generateMatrix(3);
		for (int i = 0; i < a.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + ", ");
			}
			System.out.print("]\n");
		}
		/**
		 * [ 1, 2, 3, ]
		 * [ 8, 9, 4, ]
		 * [ 7, 6, 5, ]
		 */
		
		int[][] b = obj.generateMatrix(7);
		for (int i = 0; i < b.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j] + ", ");
			}
			System.out.print("]\n");
		}
		/**
		 * [ 1, 2, 3, 4, 5, 6, 7, ]
		 * [ 24, 25, 26, 27, 28, 29, 8, ]
		 * [ 23, 40, 41, 42, 43, 30, 9, ]
		 * [ 22, 39, 48, 49, 44, 31, 10, ]
		 * [ 21, 38, 47, 46, 45, 32, 11, ]
		 * [ 20, 37, 36, 35, 34, 33, 12, ]
		 * [ 19, 18, 17, 16, 15, 14, 13, ]
		 */
	}
}

/**
 * LeetCode #59
 * LintCode #381
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example, Given n = 3, You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

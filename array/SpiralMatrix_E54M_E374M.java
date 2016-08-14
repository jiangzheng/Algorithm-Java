package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_E54M_E374M {
	/**
	 * Time: O(mn); Space: O(1)
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
    	if (matrix == null || matrix.length == 0) {
    		return list;	// invalid input
    	}
    	
		int row = matrix.length, col = matrix[0].length;
		int i = 0, j = -1;
		
		while (true) {
			for (int n = 0; n < col; n++) {
				list.add(matrix[i][++j]);	// go right
			}
			if (--row == 0) {
				break;
			}
			for (int n = 0; n < row; n++) {
				list.add(matrix[++i][j]);	// go down
			}
			if (--col == 0) {
				break;
			}
			for (int n = 0; n < col; n++) {
				list.add(matrix[i][--j]);	// go left
			}
			if (--row == 0) {
				break;
			}
			for (int n = 0; n < row; n++) {
				list.add(matrix[--i][j]);	// go up
			}
			if (--col == 0) {
				break;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		SpiralMatrix_E54M_E374M obj = new SpiralMatrix_E54M_E374M();
		System.out.println(obj.spiralOrder(null));	// []
		System.out.println(obj.spiralOrder(new int[][]{}));	// []

		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(obj.spiralOrder(a));	// [1, 2, 3, 6, 9, 8, 7, 4, 5]
		
		int[][] b = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
		System.out.println(obj.spiralOrder(b));	// [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
	}
}

/**
 * LeetCode #54
 * LintCode #374
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example, Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */

package binarysearch;

public class SearchA2DMatrix_E74M_I28E {
	/**
	 * Binary Search.
	 * Time: O(log(mn)); Space: O(1)
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;	// # of rows;
		int n = matrix[0].length;	// # of columns;
		int low = 0, high = m * n - 1;
		
		while (low < high) {
			int middle = (low + high) / 2;
			int row = middle / n, col = middle % n;	// calculate (row,col) by middle
			if (matrix[row][col] > target) {	// if middle # > target, move high to middle
				high = middle;
			} else if (matrix[row][col] < target) {	// if middle # < target, move low  to middle + 1
				low = middle + 1;
			} else {
				return true;	// if middle # = target, return true
			}
		}
		
		// For simple binary search (low=middle+1, high=middle), end of loop: low==high==middle or low==high==middle+1
		// So when middle(row,col) doesn't match target, low or high is still possible to match target
		// So have to judge once after loop.
		if (matrix[low / n][low % n] == target) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		SearchA2DMatrix_E74M_I28E obj = new SearchA2DMatrix_E74M_I28E();
		int[][] a = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		System.out.println(obj.searchMatrix(a, 11));	// true
		System.out.println(obj.searchMatrix(a, 12));	// false
		System.out.println(obj.searchMatrix(a, 0));	// false
	}
}

/**
 * LeetCode #74
 * LintCode #28
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example, Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 */

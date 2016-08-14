package array;

public class RotateImage_E48M_I161M {
	/**
	 * Time: O(n^2 / 4); Space: O(1)
	 * Rotate 90 clockwise: A -> B -> C -> D -> A
	 *             [i, j]
	 *              —— A —————————
	 *              |            |
	 *              |            B [j, (n-1)-i]
	 *              |            |
	 * [(n-1)-j, i] D            |
	 *              |            |
	 *              ————————— C ——
	 *               [(n-1)-i, (n-1)-j]
	 */
    public int[][] rotate(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) {
    		return null;	// invalid input
    	}
    	
		int n = matrix.length;
		int halfN = n / 2;	// traverse from outside square to inside square
		////int halfN = (n % 2 == 0) ? n / 2 : n / 2 + 1;	// alternate (traverse left top 1/4) 
		
		for (int i = 0; i < halfN; i++) {
			for (int j = i; j < n - 1 - i; j++) {	// traverse from outside square to inside square
			////for (int j = 0; j < n / 2; j++) { // alternate (traverse left top 1/4) 
				int k = n - 1 - i, l = n - 1 - j;
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[l][i];	// top   <- left
				matrix[l][i] = matrix[k][l];	// right <- top
				matrix[k][l] = matrix[j][k];	// down  <- right
				matrix[j][k] = tmp;	// left  <- down
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		RotateImage_E48M_I161M obj = new RotateImage_E48M_I161M();
		System.out.println(obj.rotate(null));	// null
		System.out.println(obj.rotate(new int[][]{}));	// null
		
		int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		int[][] result = obj.rotate(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.print("]\n");
		}
		/**
		 * [ 21, 16, 11, 6, 1, ]
		 * [ 22, 17, 12, 7, 2, ]
		 * [ 23, 18, 13, 8, 3, ]
		 * [ 24, 19, 14, 9, 4, ]
		 * [ 25, 20, 15, 10, 5, ]
		 */
	}
}

/**
 * LeetCode #48
 * LintCode #161
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 */

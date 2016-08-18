package math;

public class Rand7FromRand10_X994M {
	/**
	 * Time: O(?); Space: O(?) 
	 */
	public int rand7() {
		int[][] vals = {	// 10 x 10 matrix with 1~7 repetitively, fill 0 for the remaining 2 positions
				{ 1, 2, 3, 4, 5, 6, 7, 1, 2, 3 },
				{ 4, 5, 6, 7, 1, 2, 3, 4, 5, 6 },
				{ 7, 1, 2, 3, 4, 5, 6, 7, 1, 2 },
				{ 3, 4, 5, 6, 7, 1, 2, 3, 4, 5 },
				{ 6, 7, 1, 2, 3, 4, 5, 6, 7, 1 },
				{ 2, 3, 4, 5, 6, 7, 1, 2, 3, 4 },
				{ 5, 6, 7, 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 3, 4, 5, 6, 7, 1, 2, 3 },
				{ 4, 5, 6, 7, 1, 2, 3, 4, 5, 6 },
				{ 7, 1, 2, 3, 4, 5, 6, 7, 0, 0 },
			};
		
		int result = 0;
		while (result == 0) {	// run again if getting a 0
			result = vals[rand10() - 1][rand10() - 1];	// look up the matrix
		}
		
		return result;
	}
	
	/**
	 * Generate a random integer in the range 1 to 10 from Math.random().
	 * Math.random() returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
	 */
	private int rand10() {
		return (int) (Math.random() * 10) + 1;	// 1 ~ 10, not 0 ~ 9
	}
	
	public static void main(String[] args) {
		Rand7FromRand10_X994M obj = new Rand7FromRand10_X994M();
		
		for (int i = 0; i < 50; i++) {
			System.out.print(obj.rand7() + " "); 
		}
		// e.g., 2 4 3 3 4 2 5 1 5 7 2 1 7 5 5 5 3 6 6 6 3 6 5 4 1 1 6 1 7 5 3 3 7 5 2 1 1 7 4 7 7 1 4 5 6 2 2 2 7 6
	}
}

/**
 * Extra 994
 * Given a function which produces a random integer in the range 1 to 10, 
 * write a function which produces a random integer in the range 1 to 7.
 */

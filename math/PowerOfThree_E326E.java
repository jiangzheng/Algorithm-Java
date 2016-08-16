package math;

public class PowerOfThree_E326E {
	/**
	 * Check if log10(n) / log10(3) = log3(n) returns an integer.
	 * Time: O(1); Space: O(1)
	 */
	public boolean isPowerOfThree1(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
	
	/**
	 * For an int n, the max value that is a power of 3 is 1162261467 = 3^19.
	 * Time: O(1); Space: O(1)
	 */
	public boolean isPowerOfThree2(int n) {
		double threshhold = Math.floor(Math.log10(Integer.MAX_VALUE) / Math.log10(3));	// log3(Integer.MAX_VALUE) ~= 19.6
		return n > 0 && Math.pow(3.0, threshhold) % n == 0;
	}

	/**
	 * Use loop.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isPowerOfThree3(int n) {
		if (n < 1) {
			return false;
		}
		
		while (n % 3 == 0) {
			n /= 3;
		}
		
		return n == 1;
	}
	
	public static void main(String[] args) {
		PowerOfThree_E326E obj = new PowerOfThree_E326E();
		int[] data = {0, 1, 2, 3, 8, 9, 12, 243};
		for (int d : data) {
			System.out.print(obj.isPowerOfThree1(d) + "; ");	// false; true; false; true; false; true; false; true; 
		}
		System.out.print("\n");
		for (int d : data) {
			System.out.print(obj.isPowerOfThree2(d) + "; ");	// false; true; false; true; false; true; false; true; 
		}
		System.out.print("\n");
		for (int d : data) {
			System.out.print(obj.isPowerOfThree3(d) + "; ");	// false; true; false; true; false; true; false; true; 
		}		
		System.out.print("\n");
	}
}

/**
 * LeetCode #326
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up: Could you do it without using any loop / recursion?
 */

package bit;

public class PowerOfFour_E342E {
	/**
	 * e.g., n = 10000, n - 1 = 1111, 10000 & 01111 = 00000, 1111 % 3 = 0
	 * Time: O(1); Space: O(1)
	 */
	public boolean isPowerOfFour(int num) {
		return (num > 0) && ((num & (num - 1)) == 0) && ((num - 1) % 3 == 0);
	}
	
	public static void main(String[] args) {
		PowerOfFour_E342E obj = new PowerOfFour_E342E();
		System.out.println(obj.isPowerOfFour(-1));	// false
		System.out.println(obj.isPowerOfFour(0));	// false
		
		int[] data = {0, 1, 2, 16, 32, 65536};
		for (int d : data) {
			System.out.print(obj.isPowerOfFour(d) + ", ");	// false, true, false, true, false, true, 
		}
	}
}

/**
 * LeetCode #342
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example: Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 */

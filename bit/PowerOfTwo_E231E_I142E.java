package bit;

public class PowerOfTwo_E231E_I142E {
	/**
	 * e.g., n = 10000, n - 1 = 1111, 10000 & 01111 = 00000
	 * Time: O(1); Space: O(1)
	 */
	public boolean isPowerOfTwo1(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
	
	/**
	 * Check whether each bit after 1 is zero.
	 * Time: O(n); Space: O(1) 
	 */
	public boolean isPowerOfTwo2(int n) {
		if (n <= 0) {
			return false;	// invalid input
		}
		
		while (n > 0) {
			if (n != 1 && (n & 1) != 0) {
				return false;	// stop if any bit after 1 is not 0
			}
			n >>= 1;	// shift a bit to the right
		}
		
		return true;
	}
	
	/**
	 * Create a 10000...00000 and compare it with n
	 * Time: O(2n), Space: O(1)
	 */
	public boolean isPowerOfTwo3(int n) {
		int length = 0;
		int temp = n;
		while (temp > 0) {	// get how many bits
			temp >>= 1;
			length++;
		}
		
		temp = 1;
		while (--length > 0) {	// create a temp = 10000..00000
			temp <<= 1;
		}
		
		return temp == n;	// compare temp with n
	}
	
	public static void main(String[] args) {
		PowerOfTwo_E231E_I142E obj = new PowerOfTwo_E231E_I142E();
		System.out.println(obj.isPowerOfTwo1(-1));	// false
		System.out.println(obj.isPowerOfTwo2(-1));	// false
		System.out.println(obj.isPowerOfTwo3(-1));	// false
		System.out.println(obj.isPowerOfTwo1(0));	// false
		System.out.println(obj.isPowerOfTwo2(0));	// false
		System.out.println(obj.isPowerOfTwo3(0));	// false
		
		int[] data = {0, 1, 3, 2, 5, 16, 33, 65536};
		for (int d : data) {
			System.out.print(obj.isPowerOfTwo1(d) + ", ");	// false, true, false, true, false, true, false, true, 
		}
		System.out.print("\n");
		for (int d : data) {
			System.out.print(obj.isPowerOfTwo2(d) + ", ");	// false, true, false, true, false, true, false, true, 
		}
		System.out.print("\n");
		for (int d : data) {
			System.out.print(obj.isPowerOfTwo3(d) + ", ");	// false, true, false, true, false, true, false, true, 
		}		
		System.out.print("\n");
	}
}

/**
 * LeetCode #231
 * LintCode #142
 * Given an integer, write a function to determine if it is a power of two.
 */

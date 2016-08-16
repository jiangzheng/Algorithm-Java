package math;

public class FastPower_I140M {
	/**
	 * Math trick.
	 * (a + b) % n = ((a % n) + (b % n)) % n
	 * ab % n = ((a % n)(b % n)) % n
	 * (a % n) % n = a % n
	 * Time: O(log n); Space: O(1)
	 */
	public int fastPower(int a, int b, int n) {
		if (n == 1) {
			return a % b;
		}
		
		if (n == 0) {
			return 1 % b;
		}
		
		long sqrt = fastPower(a, b, n / 2);
		
		long result = (sqrt * sqrt) % b;
		if (n % 2 == 1) {
			result = (result * a) % b;
		}
		
		return (int) result;
	}
	
	public static void main(String[] args) {
		FastPower_I140M obj = new FastPower_I140M();
		System.out.println(obj.fastPower(2, 3, 31));	// 2
		System.out.println(obj.fastPower(100, 1000, 1000));	// 0
	}
}

/**
 * LintCode #140
 * Calculate the a^n % b where a, b and n are all 32bit integers.
 * Example: For 2^31 % 3 = 2, For 100^1000 % 1000 = 0
 * O(logn)
 */

package bit;

public class DivideTwoIntegers_E29M_I414M {
	/**
	 * Bit Manipulation.
	 * Time: O(log n); Space: O(1)
	 */
	int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		if (divisor == 1) {
			return dividend;
		}
		
		if (divisor == -1) {
			return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
		}
		
		// convert int to long, otherwise Math.abs(Integer.MIN_VALUE) will overflow
		long p = Math.abs((long) dividend);
		long q = Math.abs((long) divisor);
		
		long res = 0;
		while (p >= q) {
			int count = 0;
			while (p >= (q << count)) {	// q*2^n < p < q*2^(n+1)
				count++;
			}
			res += (long)1 << (count - 1);	// add 2^n
			p -= q << (count - 1);	// p <= p - q*2^n
		}
		
		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			return (res > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) res;
		} else {
			return (int)-res;
		}
	}
	
	public static void main(String[] args) {
		DivideTwoIntegers_E29M_I414M obj = new DivideTwoIntegers_E29M_I414M();
		System.out.println(obj.divide(20, 0));	// -2147483648
		
		System.out.println(obj.divide(20, 2));	// 10
	}
}

/**
 * LeetCode #29
 * LintCode #414
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */

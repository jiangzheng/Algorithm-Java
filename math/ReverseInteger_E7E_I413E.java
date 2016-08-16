package math;

public class ReverseInteger_E7E_I413E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public int reverse(int x) {
		long result = 0;
		
		while (x != 0) {
			result = result * 10 + x % 10;	// append last digit of x
			x /= 10;		// remove last digit
		}
		
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;	// if result is overflow, return 0;
		}
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		ReverseInteger_E7E_I413E obj = new ReverseInteger_E7E_I413E();
		System.out.println(obj.reverse(123));	// 321
		System.out.println(obj.reverse(-123));	// -321
		System.out.println(obj.reverse(-123456));	// -654321
	}
}

/**
 * LeetCode #7
 * LintCode #413
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Keys: Last digit is 0, Reversed integer might overflow
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? i.e., cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Throw an exception? Good, but what if throwing an exception is not an option? 
 * You would then have to re-design the function (i.e., add an extra parameter).
 */

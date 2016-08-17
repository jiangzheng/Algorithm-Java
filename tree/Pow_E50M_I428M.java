package tree;

public class Pow_E50M_I428M {
	/**
	 * Recursion.
	 * Time: O(log n); Space: O(1) 
	 */
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1.0 / power(x, -n);	// e.g., 2^-3 = 1 / 2^3
		} else {
			return power(x, n);
		}
	}
	
	private double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		
		double a = power(x, n / 2);
				
		if (n % 2 == 0) {	// if n is even, pow(x, n) = pow(x, n/2) * pow(x, n/2)
			return a * a;
		} else {	// if n is odd, pow(x, n) = pow(x, n/2) * pow(x, n/2) * x
			return a * a * x;
		}
	}
	
	public static void main(String[] args) {
		Pow_E50M_I428M obj = new Pow_E50M_I428M();
		System.out.println(obj.myPow(0.0, 0));	// 1.0
		System.out.println(obj.myPow(0.0, 3));	// 0.0
		System.out.println(obj.myPow(0.0, -3));	// Infinity
		System.out.println(obj.myPow(2.0, 0));	// 1.0
		System.out.println(obj.myPow(2.0, 3));	// 8.0
		System.out.println(obj.myPow(2.0, -3));	// 0.125
		System.out.println(obj.myPow(-2.0, 0));	// 1.0
		System.out.println(obj.myPow(-2.0, 3));	// -8.0
		System.out.println(obj.myPow(-2.0, -3));	// -0.125
	}
}

/**
 * LeetCode #50
 * LintCode #428
 * Implement pow(x, n).
 */

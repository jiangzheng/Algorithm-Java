package math;

public class UglyNumber_E263E_I517E {
	/**
	 * Use mod operation iteratively.
	 * Time: O(?); Space: O(1)
	 */
	public boolean isUgly(int num) {
		int[] primeFactors = {2, 3, 5};	// prime factors may be expanded here
		
		while (num >= 2) {
			boolean pass = false;
			for (int pf : primeFactors) {
				if (num % pf == 0) {
					num /= pf;
					pass = true;
					break;
				}
			}
			if (!pass) {
				return false;
			}
		}
		
		return num == 1;
	}
	
	public static void main(String[] args) {
		UglyNumber_E263E_I517E obj = new UglyNumber_E263E_I517E();
		for (int i = 0; i < 15; i++) {
			System.out.print(i + ":" + obj.isUgly(i) + ", ");
			// 0:false, 1:true, 2:true, 3:true, 4:true, 5:true, 6:true, 7:false, 
			// 8:true, 9:true, 10:true, 11:false, 12:true, 13:false, 14:false, 
		}
	}
}

/**
 * LeetCode #263
 * LintCode #517
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 */

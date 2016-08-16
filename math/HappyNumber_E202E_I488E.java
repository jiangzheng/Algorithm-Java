package math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_E202E_I488E {
	/**
	 * Use a Set to check duplication of sum.
	 */
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		
		int sum = n;
		while (sum != 1) {
			if (!set.contains(sum))
				set.add(sum);	// if a sum has never been stored, add this sum into the Set
			else
				return false;	// if a sum has been stored, n will not be a happy number
			sum = sumDigitSquare(sum);	// calculate sum of digit square
		}
		
		return true;
	}
	
	private int sumDigitSquare(int x) {
		int result = 0;
		
		while (x > 0) {
			result += Math.pow(x % 10, 2);
			x /= 10;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		HappyNumber_E202E_I488E obj = new HappyNumber_E202E_I488E();
		System.out.println(obj.isHappy(19));	// true
		System.out.println(obj.isHappy(20));	// false
	}
}

/**
 * LeetCode #202
 * LintCode #488
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, 
 *   replace the number by the sum of the squares of its digits, 
 *   and repeat the process until the number equals 1 (where it will stay), 
 *   or it loops endlessly in a cycle which does not include 1. 
 *   Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

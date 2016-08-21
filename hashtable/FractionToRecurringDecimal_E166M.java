package hashtable;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_E166M {
	/**
	 * Time: O(n); Space: O(n) 
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return "The denominator should not be 0.";	// invalid input
		}
		
		if (numerator == 0) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		
		// add the sign
		if (numerator < 0 ^ denominator < 0) {
			sb.append("-");
		}
		
		long n = numerator, d = denominator;	// use long to avoid overflow of -Integer.MIN_VALUE
		n = Math.abs(n);	// Math.abs can't be directly used on Integer.MIN_VALUE
		d = Math.abs(d);
		sb.append(n / d);	// add the integer part

		// add digit or stop
		long r = n % d;	// remainder, must use long type
		if (r == 0) {
			return sb.toString();
		} else {
			sb.append(".");
		}
		
		// add fractional part
		Map<Long, Integer> map = new HashMap<>();	// <remainder, position>
		while (r > 0) {
			if (map.containsKey(r)) {
				sb.insert(map.get(r), "(");
				sb.append(")");
				break;
			} else {
				map.put(r, sb.length());	// no need to -1 on sb.length() since r hasn't been added to sb
				r *= 10;
				sb.append(r / d);
				r = r % d;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		FractionToRecurringDecimal_E166M obj = new FractionToRecurringDecimal_E166M();
		System.out.println(obj.fractionToDecimal(1, 0));	// The denominator should not be 0.
		
		System.out.println(obj.fractionToDecimal(1, 2));	// 0.5
		System.out.println(obj.fractionToDecimal(2, 1));	// 2
		System.out.println(obj.fractionToDecimal(2, 3));	// 0.(6)
		System.out.println(obj.fractionToDecimal(0, 3));	// 0
	}
}

/**
 * LeetCode #166
 * Given two integers representing the numerator and denominator of a fraction, 
 *   return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */

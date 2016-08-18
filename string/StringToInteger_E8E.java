package string;

public class StringToInteger_E8E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	private static final int oneTenthOfMaxInteger = Integer.MAX_VALUE / 10;	// 2147483647 / 10 = 214748364

	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return (int) Double.NaN;	// invalid input
		}
		
		str = str.trim();	// discard both leading and trailing whitespace
		
		int i = 0, sign = +1;
		
		// find leading sign
		if (i < str.length() && str.charAt(i) == '+') {	// positive sign
			sign = +1;
			i++;
		} else if (i < str.length() && str.charAt(i) == '-') {	// negative sign
			sign = -1;
			i++;
		}
	
		// convert value (including out-of-range case)
		int value = 0;
		while (i < str.length()) {
			if (Character.isDigit(str.charAt(i))) {
				int digit = Character.getNumericValue(str.charAt(i));
				if (value > oneTenthOfMaxInteger || value == oneTenthOfMaxInteger && digit > 7) {	// INT_MAX=2147483647 or INT_MIN=-2147483648
					return sign == +1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;	// out of the range
				}
				value = value * 10 + digit;
				i++;
			} else {
				return (int) Double.NaN;	// if there is any non-digit character, return NaN
			}
		}
		
		return value * sign;
	}
	
	public static void main(String[] args) {
		StringToInteger_E8E obj = new StringToInteger_E8E();
		System.out.println(obj.myAtoi(null));	// 0
		System.out.println(obj.myAtoi(""));	// 0
		
		System.out.println(obj.myAtoi("   2147483648"));	// 2147483647
		System.out.println(obj.myAtoi("  +2147483647"));	// 2147483647
		System.out.println(obj.myAtoi("	 -2147483648"));	// -2147483648
		System.out.println(obj.myAtoi("	   -2147483649"));	// -2147483648
		System.out.println(obj.myAtoi("  2147483647 "));	// 2147483647
		System.out.println(obj.myAtoi(" adad2147483648"));	// 0
		System.out.println(obj.myAtoi(" -21a4012"));	// 0
	}
}

/**
 * LeetCode #8
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 *   If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (i.e., no given input specs). 
 *   You are responsible to gather all the input requirements up front.
 */

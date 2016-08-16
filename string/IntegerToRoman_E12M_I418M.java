package string;

public class IntegerToRoman_E12M_I418M {
	/**
	 * Keep extra symbols for 900, 400, 90, 40, 9, 4.
	 * Time: O(n); Space: O(1)
	 */
	private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		
	public String intToRoman(int num) {
		if (num < 1 || num > 3999) {
			return "Invalid Input";
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (num > 0) {		// from largest to smallest values[i], until 0
			while (num / values[i] > 0) {	// e.g., 3999 has 3 1000s
				sb.append(symbols[i]);	// append a symbol
				num -= values[i];
			}
			i++;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IntegerToRoman_E12M_I418M obj = new IntegerToRoman_E12M_I418M();
		System.out.println(obj.intToRoman(0));	// Invalid Input
		System.out.println(obj.intToRoman(4000));	// Invalid Input

		System.out.println(obj.intToRoman(1));	// I
		System.out.println(obj.intToRoman(9));	// IX
		System.out.println(obj.intToRoman(3999));	// MMMCMXCIX
	}
}

/**
 * LeetCode #12
 * LintCode #418
 * Given an integer, convert it to a Roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

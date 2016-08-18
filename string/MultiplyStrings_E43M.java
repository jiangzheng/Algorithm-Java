package string;

public class MultiplyStrings_E43M {
	/**
	 * Calculate from the end to higher digits, 
	 *   record and add up product of each digit, 
	 *   then deal with carry,
	 *   then delete leading 0.
	 * Time: O(n1 * n2); Space: O(n1 + n2)
	 */
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			return null;	// invalid input
		}
		
		// reverse the strings
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		int n1 = num1.length(), n2 = num2.length();
		
		// calculate each digit (from ones place to tens, hundreds places...)
		int[] d = new int[n1 + n2];
		for (int i = 0; i < n1; i++) {
			int d1 = num1.charAt(i) - '0';
			for (int j = 0; j < n2; j++) {
				int d2 = num2.charAt(j) - '0';
				d[i + j] += d1 * d2;
			}
		}
		
		// deal with carry
		StringBuilder str = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < n1 + n2; i++) {
			d[i] += carry;
			carry = d[i] / 10;
			str.append(d[i] % 10);
		}
		
		// trim starting zeros
		String result = str.reverse().toString();
		int start = 0;
		while (start < str.length()) {
			if (str.charAt(start) != '0') {
				break;
			}
			start++;
		}
		
		return start == str.length() ? "0" : result.substring(start);
	}
	
	public static void main(String[] args) {
		MultiplyStrings_E43M obj = new MultiplyStrings_E43M();
		System.out.println(obj.multiply(null, "50"));	// null
		System.out.println(obj.multiply("25", null));	// null
		System.out.println(obj.multiply("", "50"));	// null
		System.out.println(obj.multiply("25", ""));	// null
		
		System.out.println(obj.multiply("25", "50"));	// 1250
	}
}

/**
 * LeetCode #43
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

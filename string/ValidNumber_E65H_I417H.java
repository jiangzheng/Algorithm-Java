package string;

public class ValidNumber_E65H_I417H {
	/**
	 * Time: O(n); Space: O(1) 
	 */
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		
		int i = 0, n = s.length();
		
		// leading whitespace
		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		
		// sign
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			i++;
		}
		
		// digits before '.'
		boolean isNumeric = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		
		// digits from '.' to 'e'
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		
		// digits after 'e'
		if (isNumeric && i < n && s.charAt(i) == 'e') {
			i++;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				i++;
			}
			isNumeric = false;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		
		// trailing whitespace
		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		
		return isNumeric && i == n;
	}
	
	public static void main(String[] args) {
		ValidNumber_E65H_I417H obj = new ValidNumber_E65H_I417H();
		System.out.println(obj.isNumber(null));	// false
		System.out.println(obj.isNumber(""));	// false
		
		System.out.println(obj.isNumber("0"));	// true
		System.out.println(obj.isNumber(" 0.1 "));	// true
		System.out.println(obj.isNumber("abc"));	// false
		System.out.println(obj.isNumber("1 a"));	// false
		System.out.println(obj.isNumber("2e10"));	// true
	}
}

/**
 * LeetCode #65
 * LintCode $417
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note:
 * - It is intended for the problem statement to be ambiguous. 
 * - You should gather all requirements up front before implementing one.
 */

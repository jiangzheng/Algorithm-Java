package string;

public class AddBinary_E67E_I408E {
	/**
	 * Calculate from the lowest place to highest place, then reverse the whole string.
	 * Time: O(Max{na, nb}); Space: O(Max{na, nb})
	 */
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0 || b == null || b.length() == 0){
			return null;	// invalid input
		}
		
		StringBuilder sb = new StringBuilder();
		int place = 2;  // binary
		int digit = 0, carry = 0;
		
		for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
			int digitA = 0, digitB = 0;
			if (i < a.length()){
				char charA = a.charAt(a.length() - 1 - i);
				if (charA != '0' && charA != '1') {
					return null;	// invalid input
				}
				digitA = Character.getNumericValue(charA);
			}
			if (i < b.length()){
				char charB = b.charAt(b.length() - 1 - i);
				if (charB != '0' && charB != '1') {
					return null;	// invalid input
				}
				digitB = Character.getNumericValue(charB);
			}
			int sum = digitA + digitB + carry;
			digit = sum % place;	// digit for current place
			carry = sum / place;	// carry to the higher next place
			sb.append(digit);
		}
		
		if (carry > 0) { 
			sb.append(carry);	// for the highest place, if needed
		}
		
		return sb.reverse().toString();	// reverse the whole string
	}
	
	public static void main(String[] args) {
		AddBinary_E67E_I408E obj = new AddBinary_E67E_I408E();
		System.out.println(obj.addBinary(null, null));	// null
		System.out.println(obj.addBinary("", null));	// null
		System.out.println(obj.addBinary(null, ""));	// null
		System.out.println(obj.addBinary("3", "2"));	// null
		
		System.out.println(obj.addBinary("11", "1"));	// 100
		System.out.println(obj.addBinary("110", "1011"));	// 10001
	}
}

/**
 * LeetCode #67
 * LintCode #408
 * Given two binary strings, return their sum (also a binary string).
 * For example, a = "11", b = "1", Return "100".
 */

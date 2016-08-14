package array;

public class PlusOne_E66E_I407E {
	/**
	 * Time: O(n); Space: O(1), worst case: O(n)
	 */
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 < 10) {	// no carry
				digits[i]++;
				return digits;
			} else {
				if (i == 0) {	// if the highest digit, then 100...00
					int[] newNumber = new int[digits.length + 1];
					newNumber[0] = 1;
					return newNumber;
				} else {
					digits[i] = 0;
				}
			}
		}
		
		return digits;
	}
	
	public static void main(String[] args) {
		PlusOne_E66E_I407E obj = new PlusOne_E66E_I407E();
		int[] a = new int[]{9, 9, 9, 9, 9};
		int[] result = obj.plusOne(a);
		for (int n : result) {
			System.out.print(n);	// 100000
		}
	}
}

/**
 * LeetCode #66
 * LintCode $407
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */

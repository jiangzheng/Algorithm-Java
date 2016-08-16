package string;

public class ExcelSheetColumnTitle_E168E {
	/**
	 * String manipulation.
	 * Time: O(n); Space: O(n)
	 */
	public String convertToTitle(int n) {
		if (n < 1) {
			return "Invalid Input";
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			sb.append((char)(--n % 26 + 'A'));	// 'A' = 1 instead of 0
			n /= 26;
		}
		
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle_E168E obj = new ExcelSheetColumnTitle_E168E();
		System.out.println(obj.convertToTitle(-1));	// Invalid input

		System.out.println(obj.convertToTitle(1));	// A
		System.out.println(obj.convertToTitle(26));	// Z
		System.out.println(obj.convertToTitle(28));	// AB
		System.out.println(obj.convertToTitle(704));	// AAB
		System.out.println(obj.convertToTitle(Integer.MAX_VALUE));	// FXSHRXW
	}
}

/**
 * LeetCode #168
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example: 1 -> A, 2 -> B, 3 -> C, ..., 26 -> Z, 27 -> AA, 28 -> AB 
 */

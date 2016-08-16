package string;

public class ExcelSheetColumnNumber_E171E {
	/**
	 * String manipulation.
	 * Time: O(n); Space: O(1)
	 */
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return -1;	// invalid input
		}
		
		int count = 0;
		for (int i = 0; i < s.length(); i++) {	// from the first letter to the last letter
			if (s.charAt(i) < 'A' || s.charAt(i) > 'Z') {
				return -1;	// invalid input
			}
			count = count * 26 + (int)(s.charAt(i) - 'A' + 1);	// calculate the number
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		ExcelSheetColumnNumber_E171E obj = new ExcelSheetColumnNumber_E171E();
		System.out.println(obj.titleToNumber(null));	// -1
		System.out.println(obj.titleToNumber(""));	// -1
		System.out.println(obj.titleToNumber("_"));	// -1
		System.out.println(obj.titleToNumber("az"));	// -1
		
		System.out.println(obj.titleToNumber("A"));	// 1
		System.out.println(obj.titleToNumber("Z"));	// 26
		System.out.println(obj.titleToNumber("AB"));	// 28
		System.out.println(obj.titleToNumber("AAB"));	// 704
		System.out.println(obj.titleToNumber("FXSHRXW"));	// 2147483647
	}
}

/**
 * LeetCode #171
 * Related to question (168) Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example: A -> 1, B -> 2, C -> 3, ..., Z -> 26, AA -> 27, AB -> 28 
 */

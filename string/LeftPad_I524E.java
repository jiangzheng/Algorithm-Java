package string;

public class LeftPad_I524E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	static public String leftPad(String originalStr, int size, char padChar) {
		if (originalStr == null) {
			return null;	// invalid input
		}
		
		if (size <= originalStr.length()) {
			return originalStr;	// shortcut
		}
		
		String pad = "";
		for (int i = 0; i < size - originalStr.length(); i++) {
			pad += padChar;
		}
        return pad + originalStr;
	}
	
	/**
	 * Time: O(n); Space: O(1)
	 */
	static public String leftPad(String originalStr, int size) {
		return leftPad(originalStr, size, ' ');
	}
	
	public static void main(String[] args) {
		System.out.println(leftPad(null, 5));	// null
		System.out.println(leftPad(null, 5, '-'));	// null
		System.out.println(leftPad("", 5));	// "     "
		System.out.println(leftPad("", 5, '-'));	// "-----"

		System.out.println(leftPad("foo", 5));	// "  foo"
		System.out.println(leftPad("foobar", 6));	// "foobar"
		System.out.println(leftPad("1", 2, '0'));	// "01"
	}
}

/**
 * LintCode #524
 * Your job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.
 * leftpad("foo", 5) >> "  foo"
 * leftpad("foobar", 6) >> "foobar"
 * leftpad("1", 2, "0") >> "01"
 */

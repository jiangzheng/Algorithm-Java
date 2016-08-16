package string;

public class LengthOfLastWord_E58E_I422E {
	/**
	 * String manipulation.
	 * Time: O(n); Space: O(1)
	 */
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;	// invalid input
		}
		
		int length = 0;
		int pointer = s.length() - 1;
		
		while (pointer >= 0 && s.charAt(pointer) == ' ') {	// Ignore all trailing spaces
			pointer--;
		}
		
		while (pointer >= 0 && s.charAt(pointer) != ' ') {	// Until reaching a ' '
			pointer--;
			length++;
		}
		
		return length;
	}
	
	public static void main(String[] args) {
		LengthOfLastWord_E58E_I422E obj = new LengthOfLastWord_E58E_I422E();
		System.out.println(obj.lengthOfLastWord(null));	// 0
		System.out.println(obj.lengthOfLastWord(""));	// 0
		
		System.out.println(obj.lengthOfLastWord("Hello World"));	// 5
		System.out.println(obj.lengthOfLastWord("   Hello World		"));	// 7 (trailing tabs)
		System.out.println(obj.lengthOfLastWord(" empty space chara-cters "));	// 11
	}
}

/**
 * LeetCode #58
 * LintCode #422
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 *   return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, Given s = "Hello World", return 5.
 */

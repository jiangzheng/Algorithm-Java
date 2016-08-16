package string;

public class ReverseWordsInAStringII_E186M {
	/**
	 * Reverse the whole string, then reverse each word.
	 * Time: O(n); Space: O(1)
	 */
	public void reverseWords(char[] s) {
		if (s == null || s.length == 0) {
			return;	// invalid input
		}
		
		reverse(s, 0, s.length - 1);	// Reverse the whole string
		
		int pointer = 0;
		for (int i = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {	// end of string, or see a space
				reverse(s, pointer, i - 1);	// reverse each word
				pointer = i + 1;	// set pointer as next to the space
			}
		}
	}
	
	private void reverse(char[] c, int from, int to) {
		while (from < to) {
			char temp = c[from];
			c[from++] = c[to];
			c[to--] = temp;
		}
	}
	
	public static void main(String[] args) {
		ReverseWordsInAStringII_E186M obj = new ReverseWordsInAStringII_E186M();
		char[] c = new char[]{};
		obj.reverseWords(c);
		System.out.println("[" + new String(c) + "]");	// []
		
		c = "the sky is blue".toCharArray();
		obj.reverseWords(c);
		System.out.println("[" + new String(c) + "]");	// [blue is sky the]
	}
}

/**
 * LeetCode #186
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 */

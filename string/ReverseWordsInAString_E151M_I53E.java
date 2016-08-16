package string;

public class ReverseWordsInAString_E151M_I53E {
	/**
	 * One pass, scan from right to left.
	 * Time: O(n); Space: O(n)
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;	// invalid input
		}

		StringBuilder sb = new StringBuilder();	// StringBuilder is faster than String
		int pointer = s.length();	// point to the index right after each word
		
		for (int i = s.length() - 1; i >= 0; i--) {	// scan from right to left
			if (s.charAt(i) == ' ') {	// ignore multiple spaces
				pointer = i;			// point to the ' ' next to each word
			} else if (i == 0 || s.charAt(i - 1) == ' ') {	// if finish scanning, or there is a space before this char
				if (sb.length() > 0) {
					sb.append(" ");	// append a space before appending a word except for the first one
				}
				sb.append(s.substring(i, pointer));	// append the word
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ReverseWordsInAString_E151M_I53E obj = new ReverseWordsInAString_E151M_I53E();
		System.out.println(obj.reverseWords(null));	// null
		System.out.println(obj.reverseWords(""));	// ""
		
		System.out.println(obj.reverseWords("the sky is blue"));	// blue is sky the
		System.out.println(obj.reverseWords("  the   sky    is blue   "));	// blue is sky the
	}
}

/**
 * LeetCode #151
 * LintCode #53
 * Given an input string, reverse the string word by word.
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */

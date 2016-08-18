package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_E68H {
	/**
	 * Time: O(n); Space: O(n) 
	 */
	public List<String> fullJustify(String[] words, int maxWidth) {
		if (words == null || words.length == 0 || maxWidth <= 0) {
			return null;	// invalid input
		}
		
		List<String> list = new ArrayList<>();
		int strLen = 0;	// length of all strings in a line with a single space in each interval
		int start = 0, end = 0;
		
		for (int i = 0; i < words.length; i++) {
			if (strLen == 0 || strLen + words[i].length() + 1 <= maxWidth) {	// add word if <= maxWidth chars
				if (strLen > 0)
					strLen += 1;
				strLen += words[i].length();
				end = i;
			} else {	// form a line if > maxWidth chars
				list.add(formLine(words, start, end, strLen, maxWidth));
				strLen = words[i].length();
				start = i;
				end = i;
			}
		}
		
		list.add(formLine(words, start, end, strLen, maxWidth));	// form the last time
		
		return list;
	}
	
	private String formLine(String[] words, int start, int end, int strLen, int L) {
		int N = end - start;	// number of intervals
		int M = L - strLen;		// extra spaces
		StringBuilder str = new StringBuilder();
		
		if (N == 0 || end == words.length - 1) {	// left-adjusted for one word or last line
			for (int i = start; i <= end; i++) {
				if (i > start) {
					str.append(" ");
				}
				str.append(words[i]);
			}
			for (int i = 0; i < M; i++)
				str.append(" ");
		} else {
			for (int i = start; i <= end; i++) {
				if (i == start) {
					str.append(words[i]);
				} else {
					for (int j = 0; j < 1 + M / N; j++) {
						str.append(" ");	// evenly distribute space
					}
					if (i <= start + M % N) {
						str.append(" ");	// add extra space from beginning
					}
					str.append(words[i]);
				}
			}
		}
		
		return str.toString();
	}
	
	public static void main(String[] args) {
		TextJustification_E68H obj = new TextJustification_E68H();
		System.out.println(obj.fullJustify(null, 16));	// null
		System.out.println(obj.fullJustify(new String[]{}, 16));	// null
		
		String[] str = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> list = obj.fullJustify(str, 16);
		for (String s : list) {
			System.out.println("\"" + s + "\"");
		}
		/**
		 * "This    is    an"
		 * "example  of text"
		 * "justification.  "
		 */
	}
}

/**
 * Given an array of words and a length L, 
 *   format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; 
 *   that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 *   the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example, words: ["This", "is", "an", "example", "of", "text", "justification."] L: 16.
 * Return the formatted lines as:
 * [
 *   "This    is    an",
 *   "example  of text",
 *   "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 */

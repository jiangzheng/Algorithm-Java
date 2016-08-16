package string;

import java.util.ArrayList;

public class LongestWords_I133E {
	/**
	 * Time: O(n); Space: O(n)
	 */
	ArrayList<String> longestWords(String[] dictionary) {
		if (dictionary == null || dictionary.length == 0) {
			return null;	// invalid input
		}
		
		ArrayList<String> list = new ArrayList<String>();

		if (dictionary.length == 1) {
			list.add(dictionary[0]);
			return list;	// shortcut
		}
		
		for (String s : dictionary) {
			if (list.size() == 0 || list.get(0).length() < s.length()) {	// find a longer string
				list.clear();
				list.add(s);
			} else if (list.get(0).length() == s.length()) {	// same length string
				list.add(s);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		LongestWords_I133E obj = new LongestWords_I133E();
		System.out.println(obj.longestWords(null));	// null
		System.out.println(obj.longestWords(new String[]{}));	// null
		System.out.println(obj.longestWords(new String[]{"one"}));	// [one]
		
		String[] a = {"dog", "google", "facebook", "internationalization", "blabla"};
		String[] b = {"like", "love", "hate", "yes"};
		System.out.println(obj.longestWords(a));	// [internationalization]
		System.out.println(obj.longestWords(b));	// [like, love, hate]
	}
}

/**
 * LintCode #133
 * Given a dictionary, find all of the longest words in the dictionary.
 * Example
 * Given {"dog", "google", "facebook", "internationalization", "blabla"}
 *   the longest words are(is) ["internationalization"].
 * Given {"like", "love", "hate", "yes"} the longest words are ["like", "love", "hate"].
 * It's easy to solve it in two passes, can you do it in one pass?
 */

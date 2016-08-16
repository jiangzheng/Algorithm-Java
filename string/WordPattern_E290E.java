package string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_E290E {
	/**
	 * Use Map. Similar to IsomorphicStrings_E205E.
	 * Time: O(n); Space: O(1)
	 */
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
			return false;	// invalid input
		}
		
		String[] words = str.split(" ");
		if (pattern.length() != words.length) {
			return false;	// shortcut
		}
		
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char letter = pattern.charAt(i);
			String word = words[i];
			if (!map.containsKey(letter)) {	// if a new letter
				if (map.containsValue(word)) {	// if the word has been matched to a letter, return false;
					return false;
				} else {
					map.put(letter, word);	// otherwise put (letter, word) into HashMap
				}
			} else {	// if an old letter
				if (!map.get(letter).equals(word)) {	// if not matching, return false
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		WordPattern_E290E obj = new WordPattern_E290E();
		System.out.println(obj.wordPattern(null, null));	//false
		System.out.println(obj.wordPattern("", null));	//false
		System.out.println(obj.wordPattern(null, ""));	//false
		System.out.println(obj.wordPattern("abba", "dog cat cat cat dog"));	//false
		
		System.out.println(obj.wordPattern("abba", "dog cat cat fish"));	//false
		System.out.println(obj.wordPattern("aaa", "dog cat cat dog"));	//false
		System.out.println(obj.wordPattern("abba", "dog dog dog dog"));	//false
		
		System.out.println(obj.wordPattern("a", "dog"));	//true
		System.out.println(obj.wordPattern("abba", "dog cat cat dog"));	//true
	}
}

/**
 * LeetCode #290
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes: You may assume pattern contains only lowercase letters, 
 *   and str contains lowercase letters separated by a single space.
 */

package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_E205E {
	/**
	 * Use Map. Similar to WordPattern_E290E.
	 * Time: O(n); Space: O(1)
	 */
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;	// invalid input
		}
		
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char charS = s.charAt(i), charT = t.charAt(i);
			if (!map.containsKey(charS)) {	// if a new letter
				if (map.containsValue(charT)) {	// if charT has been matched to a letter, return false;
					return false;
				} else {
					map.put(charS, charT);	// otherwise put (charS, charT) into HashMap
				}
			} else {	// if an old letter
				if (map.get(charS) != charT) {	// if not matching, return false
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		IsomorphicStrings_E205E obj = new IsomorphicStrings_E205E();
		System.out.println(obj.isIsomorphic(null, null));	// false
		System.out.println(obj.isIsomorphic(null, "add"));	// false
		System.out.println(obj.isIsomorphic("egg", null));	// false
		System.out.println(obj.isIsomorphic("", "a"));	// false
		System.out.println(obj.isIsomorphic("e", ""));	// false

		System.out.println(obj.isIsomorphic("foo", "bar"));	// false
		System.out.println(obj.isIsomorphic("bar", "foo"));	// false
		System.out.println(obj.isIsomorphic("", ""));	// true
		System.out.println(obj.isIsomorphic("egg", "add"));	// true
		System.out.println(obj.isIsomorphic("paper", "title"));	// true
		System.out.println(obj.isIsomorphic("(-_-)|||", "\\dad/!!!"));	// true
	}
}

/**
 * LeetCode #205
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note: You may assume both s and t have the same length.
 */

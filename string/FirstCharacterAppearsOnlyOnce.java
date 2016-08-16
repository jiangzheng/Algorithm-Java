package string;

import java.util.HashMap;
import java.util.Map;

public class FirstCharacterAppearsOnlyOnce {
	/**
	 * Time: O(n); Space: O(26)
	 */
	public String firstOnce(String str) {
		if (str == null || str.length() == 0) {
			return null;	// invalid input
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();	// <char a-z, frequency>
		for (char c = 'a'; c <= 'z'; c++) {
			map.put(c, 0);
		}
		
		for (char c : str.toCharArray()) {	// get frequency for each character a-z
			map.put(c, map.get(c) + 1);
		}
		
		for (char c : str.toCharArray()) {	// get the first character who's count is 1
			if (map.get(c) == 1) {
				return String.valueOf(c);
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		FirstCharacterAppearsOnlyOnce obj = new FirstCharacterAppearsOnlyOnce();
		System.out.println(obj.firstOnce(null));	// null
		System.out.println(obj.firstOnce(""));	// null
		
		System.out.println(obj.firstOnce("leetcode"));	// l
		System.out.println(obj.firstOnce("abacdddebf"));	// c
	}
}

/**
 * Given a String of [a-z] characters, find and return the first character that appears only once.
 * http://stackoverflow.com/questions/14922454/how-to-find-the-first-character-in-a-given-string-that-appears-only-once
 */

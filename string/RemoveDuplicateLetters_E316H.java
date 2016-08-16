package string;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters_E316H {
	/** 
	 * Result is the smallest in lexicographical order among all possible results.
	 * Time: O(n); Space: O(n)
	 */
	public String removeDuplicateLetters1(String s) {
		if (s == null || s.length() <= 1) {
			return s;	// invalid input and shortcut
		}
		
		Map<Character, Integer> map = new HashMap<>();	// <character, last index>
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);	// cbacdcbc - c: 7, b: 6, a: 2, d: 4
		}
		
		// for each character, find the smallest index in the map, then find out the smallest char before the index
		StringBuilder sb = new StringBuilder();
		int from = 0;
		int to = findSmallestIndex(map);	// 2
		
		while (!map.isEmpty()) {
			char curr = 'z' + 1;
			int index = 0;
			for (int i = from; i <= to; i++) {
				char c = s.charAt(i);
				if (map.containsKey(c) && c < curr) {
					curr = c;
					index = i;
				}
			}
			
			sb.append(curr);	// append result
			map.remove(curr);	// remove the letter from the map
			
			from = index + 1;	// update the from and to
			to = findSmallestIndex(map);
		}
		
		return sb.toString();
	}
	
	private int findSmallestIndex(Map<Character, Integer> map) {
		int smallestIndex = Integer.MAX_VALUE;
		for (int index : map.values()) {
			smallestIndex = Math.min(smallestIndex, index);
		}
		return smallestIndex;
	}
	
	/**
	 * Result in lexicographical order anyway.
	 * Time: O(?); Space: O(?)
	 */
	public String removeDuplicateLetters2(String s) {
		if (s == null || s.length() <= 1) {
			return s;	// invalid input and shortcut
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();	// <char a-z, frequency>
		for (char c = 'a'; c <= 'z'; c++) {
			map.put(c, 0);
		}
		
		for (char c : s.toCharArray()) {	// get frequency for each character a-z
			map.put(c, map.get(c) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() >= 1) {
				sb.append(m.getKey());
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RemoveDuplicateLetters_E316H obj = new RemoveDuplicateLetters_E316H();
		System.out.println(obj.removeDuplicateLetters1(null));	// null
		System.out.println(obj.removeDuplicateLetters2(null));	// null
		System.out.println(obj.removeDuplicateLetters1(""));	// ""
		System.out.println(obj.removeDuplicateLetters2(""));	// ""
		
		System.out.println(obj.removeDuplicateLetters1("bcabc"));	// abc
		System.out.println(obj.removeDuplicateLetters2("bcabc"));	// abc
		System.out.println(obj.removeDuplicateLetters1("cbacdcbc"));	// acdb
		System.out.println(obj.removeDuplicateLetters2("cbacdcbc"));	// abcd
	}
}

/**
 * LeetCode #316
 * Given a string which contains only lowercase letters, 
 *   remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * Example: Given "bcabc", Return "abc"; Given "cbacdcbc", Return "acdb"
 */

/**
 * The basic idea is to find out the smallest result letter by letter (one letter at a time).
 * Here is the thinking process for input "cbacdcbc":
 * 1. find out the last appeared position for each letter; c - 7 b - 6 a - 2 d - 4
 * 2. find out the smallest index from the map in step 1 (a - 2);
 * 3. the first letter in the final result must be the smallest letter from index 0 to index 2;
 * 4. repeat step 2 to 3 to find out remaining letters.
 * - the smallest letter from index 0 to index 2: a
 * - the smallest letter from index 3 to index 4: c
 * - the smallest letter from index 4 to index 4: d
 * - the smallest letter from index 5 to index 6: b
 * so the result is "acdb"
 * Notes:
 * - after one letter is determined in step 3, it need to be removed from the "last appeared position map", 
 *   and the same letter should be ignored in the following steps
 * - in step 3, the beginning index of the search range should be the index of previous determined letter plus one
*/

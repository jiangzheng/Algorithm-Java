package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_E249E {
	/**
	 * Time: O(?); Space: O(?)
	 */
	public List<List<String>> groupStrings(String[] strings) {
		if (strings == null || strings.length == 0) {
			return null;	// invalid input
		}
		
		List<List<String>> listList = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for (String s: strings) {
			char[] c = s.toCharArray();
			if (c.length > 0) {
				int diff = c[0] - 'a';
				for (int i = 0; i < c.length; i++) {
					if (c[i] - diff < 'a') {
						c[i] = (char)(c[i] - diff + 26);
					} else {
						c[i] = (char)(c[i] - diff); 
					}
				}
			}
	 
			String sOfc = new String(c);
			if (map.containsKey(sOfc)) {
				map.get(sOfc).add(s);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(sOfc, list);
			}
		}
		
		// sort the map
		for (Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
			Collections.sort(entry.getValue());
		}
		
		// add to the result list
		listList.addAll(map.values());
	 
		return listList;
	}
	
	public static void main(String[] args) {
		GroupShiftedStrings_E249E obj = new GroupShiftedStrings_E249E();
		System.out.println(obj.groupStrings(null));	// null
		System.out.println(obj.groupStrings(new String[]{}));	// null
		
		String[] s = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> listList = obj.groupStrings(s);
		for (List<String> list : listList) {
			System.out.println(list);
			/**
			 * [a, z]
			 * [abc, bcd, xyz]
			 * [az, ba]
			 * [acef]
			 */
		}
	}
}

/**
 * LeetCode #249
 * Given a string, we can "shift" each of its letter to its successive letter, 
 *   for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, 
 *   group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * Return:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */

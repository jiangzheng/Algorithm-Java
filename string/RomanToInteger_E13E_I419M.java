package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_E13E_I419M {
	/**
	 * Use Map to store symbols and values, watch out subtractive rule for e.g., IX.
	 * Time: O(n); Space: O(1) 
	 */
	private static final char[] symbols = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
	private static final int[] values = {1000, 500, 100, 50, 10, 5, 1};

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return -1;	// invalid input
		}
		
		Map<Character, Integer> map = new HashMap<>();	// <symbol, value>
		for (int i = 0; i < symbols.length; i++) {
			map.put(symbols[i], values[i]);
		}
		
		int number = 0, prev = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				return -1;	// invalid input
			}
			int curr = map.get(s.charAt(i));	// NullPointerException if the character is not in the symbols array
			number += (curr <= prev) ? curr : (curr - 2 * prev);	// subtractive rule for e.g., IX
			prev = curr;
		}
		
		return number;		
	}
	
	public static void main(String[] args) {
		RomanToInteger_E13E_I419M obj = new RomanToInteger_E13E_I419M();
		System.out.println(obj.romanToInt(null));	// -1
		System.out.println(obj.romanToInt(""));	// -1
		System.out.println(obj.romanToInt("IAX"));	// -1

		System.out.println(obj.romanToInt("I"));	// 1
		System.out.println(obj.romanToInt("IX"));	// 9
		System.out.println(obj.romanToInt("MIC"));	// 1099
		System.out.println(obj.romanToInt("MMMCMXCIX"));	// 3999
	}
}

/**
 * LeetCode #13
 * LintCode #419
 * Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

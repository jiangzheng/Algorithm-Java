package string;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings_E271M {
	/**
	 * Encode.
	 * Time: O(n); Space: O(1)
	 */
	public String encode(List<String> strs) {
		if (strs == null || strs.size() == 0) {
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		 
		for (String s : strs) {
			if (s == null || s.length() == 0) {
				sb.append("0#");
			} else {
				sb.append(s.length() + "#" + s);
			}
		}
		 
		return sb.toString();
	}
	
	/**
	 * Decode.
	 * Time: O(n); Space: O(1)
	 */
	public List<String> decode(String s) {
		List<String> list = new ArrayList<>();
		
		if (s == null || s.length() == 0) {
			return list;
		}
		 
		int i = 0;
		while (i < s.length()) {
			int j = i;
			while (j < s.length() && Character.isDigit(s.charAt(j))) {
				j++;
			}
			 
			int num = Integer.parseInt(s.substring(i, j));
			i = j;
			i++;	// skip '#'
			
			if (num == 0) {
				list.add("");
			} else {
				list.add(s.substring(i, i + num));
			}
			 
			i += num;
		}
		 
		return list;
	}
	
	public static void main(String[] args) {
		EncodeAndDecodeStrings_E271M obj = new EncodeAndDecodeStrings_E271M();
		
		List<String> list = new ArrayList<String>();
		list.add("LeetCode"); list.add("LintCode"); list.add("Java"); list.add(""); list.add("Algorithms"); 
		System.out.println(obj.decode(obj.encode(list)));	// [LeetCode, LintCode, Java, , Algorithms]
	}
}

/**
 * LeetCode #271
 * Design an algorithm to encode a list of strings to a string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does: string encoded_string = encode(strs);
 * and Machine 2 does: vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * Implement the encode and decode methods.
 * Note:
 * - The string may contain any possible characters out of 256 valid ascii characters. 
 *   Your algorithm should be generalized enough to work on any possible characters.
 * - Do not use class member/global/static variables to store states. 
 *   Your encode and decode algorithms should be stateless.
 * - Do not rely on any library method such as eval or serialize methods. 
 *   You should implement your own encode/decode algorithm.
 */

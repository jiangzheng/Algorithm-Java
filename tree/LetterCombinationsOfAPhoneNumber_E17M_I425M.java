package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_E17M_I425M {
	/**
	 * DFS recursion, backtracking.
	 * Time: O(n!); Space: O(n) 
	 */
	@SuppressWarnings("serial")
	private static final Map<Character, Character[]> map = new HashMap<Character, Character[]>() {{
		put('2', new Character[]{'a', 'b', 'c'});
		put('3', new Character[]{'d', 'e', 'f'});
		put('4', new Character[]{'g', 'h', 'i'});
		put('5', new Character[]{'j', 'k', 'l'});
		put('6', new Character[]{'m', 'n', 'o'});
		put('7', new Character[]{'p', 'q', 'r', 's'});
		put('8', new Character[]{'t', 'u', 'v'});
		put('9', new Character[]{'w', 'x', 'y', 'z'});
	}};
	
	private List<String> list;
	private StringBuilder sb;
	
	public List<String> letterCombinations(String digits) {
		list = new ArrayList<String>();
		sb = new StringBuilder();
		
		if (digits == null || digits.length() == 0) {
			return list;	// invalid input
		}
		
		dfs(digits, 0);
		
		return list;
	}
	
	private void dfs(String digits, int from) {
		if (sb.length() == digits.length()) {
			list.add(sb.toString());	// complete a combination
		} else {
			for (int i = from; i < digits.length(); i++) {
				for (char c : map.get(digits.charAt(i))) {
					sb.append(c);
					dfs(digits, i + 1);
					sb.deleteCharAt(sb.length() - 1);	// backtrack: remove the last char, then probe another branch of the tree
				}
			}
		}
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber_E17M_I425M obj = new LetterCombinationsOfAPhoneNumber_E17M_I425M();
		System.out.println(obj.letterCombinations(null));	// []
		System.out.println(obj.letterCombinations(""));	// []
		
		System.out.println(obj.letterCombinations("23"));	// [ad, ae, af, bd, be, bf, cd, ce, cf]
	}
}

/**
 * LeetCode #17
 * LintCode #425
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 2:abc, 3:def, 4:ghi, 5:jkl, 6:mno, 7:pqrs, 8:tuv, 9:wxyz
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

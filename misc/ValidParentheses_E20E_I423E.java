package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_E20E_I423E {
	/**
	 * Use Stack.
	 * Time: O(n); Space: O(1) 
	 */
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for (Character c : s.toCharArray()) {
			if (stack.isEmpty() || map.containsKey(c)) {	// empty stack or c is '(', '[', or '{'
				stack.push(c);
			} else {
				if (!c.equals(map.get(stack.pop()))) {	// c is ')', ']', or '}'
					return false;
				}
			}
		}
		
		return stack.isEmpty();	// not empty -> not valid
	}
	
	@SuppressWarnings("serial")
	public static final Map<Character, Character> map = new HashMap<Character, Character>() {{
		put('(', ')');
		put('[', ']');
		put('{', '}');
	}};
	
	public static void main(String[] args) {
		ValidParentheses_E20E_I423E obj = new ValidParentheses_E20E_I423E();
		System.out.println(obj.isValid(null));	// false
		System.out.println(obj.isValid(""));	// false
		
		System.out.println(obj.isValid("([)]"));	// false
		System.out.println(obj.isValid("}}}{{{"));	// false
		
		System.out.println(obj.isValid("()[]{}"));	// true
		System.out.println(obj.isValid("{[()]({}[])}"));	// true
		
	}
}

/**
 * LeetCode #20
 * LintCode #423
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 *   determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

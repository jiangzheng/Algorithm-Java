package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation_E150M_I424M {
	/**
	 * Push the elements into Stack, once see an operator, 
	 *   pop out two elements and do the operation, and push back the result.
	 * Create an Operator to make the code more maintainable and extensible.
	 * Time: O(n); Space: O(n)
	 */
	interface Operator {
		int evaluate(int x, int y);
	}
	
	private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>() {{
		put("+", new Operator() { public int evaluate(int x, int y) {return x + y;} });
		put("-", new Operator() { public int evaluate(int x, int y) {return x - y;} });
		put("*", new Operator() { public int evaluate(int x, int y) {return x * y;} });
		put("/", new Operator() { public int evaluate(int x, int y) {return x / y;} });
	}};
	
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for (String s : tokens) {
			if (OPERATORS.containsKey(s)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS.get(s).evaluate(x, y));
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		
		return stack.pop();   
	}
	
	public static void main(String[] args) {
		EvaluateReversePolishNotation_E150M_I424M obj = new EvaluateReversePolishNotation_E150M_I424M();
		System.out.println(obj.evalRPN(null));	// -2147483648
		System.out.println(obj.evalRPN(new String[]{}));	// -2147483648
		
		String[] a = {"2", "1", "+", "3", "*"};
		String[] b = {"4", "13", "5", "/", "+"};
		System.out.println(obj.evalRPN(a));	// 9
		System.out.println(obj.evalRPN(b));	// 6
	}
}

/**
 * LeetCode #150
 * LintCode #424
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

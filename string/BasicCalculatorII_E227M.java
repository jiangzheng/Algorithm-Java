package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorII_E227M {
	/**
	 * Reverse polish notation. Shunting-yard algorithm.
	 * Time: O(3n); Space: O(2n) 
	 */
	interface Operator {
		int evaluate(int x, int y);
	}
	
	private static final Map<String, Operator> OPERATORS;
	
	static {
		OPERATORS = new HashMap<String, Operator>();
		OPERATORS.put("+", new Operator() { public int evaluate(int x, int y) {return x + y;} });
		OPERATORS.put("-", new Operator() { public int evaluate(int x, int y) {return x - y;} });
		OPERATORS.put("*", new Operator() { public int evaluate(int x, int y) {return x * y;} });
		OPERATORS.put("/", new Operator() { public int evaluate(int x, int y) {return x / y;} });
	}

	private static final Map<String, Integer> OPERATORS_PRIORITY;
	
	static {
		OPERATORS_PRIORITY = new HashMap<String, Integer>();
		OPERATORS_PRIORITY.put("+", 1);
		OPERATORS_PRIORITY.put("-", 1);
		OPERATORS_PRIORITY.put("*", 2);
		OPERATORS_PRIORITY.put("/", 2);
	}
	
	// convert an expression string to a string array 
	private String[] toStrArray(String s) {
		Queue<String> queue = new LinkedList<>();
		int n = s.length(), pointer = 0;
		
		while (pointer < n) {
			char c = s.charAt(pointer);
			
			if (Character.isDigit(c)) {		// numbers
				int v = Character.getNumericValue(c);
				while (pointer < n - 1 && Character.isDigit(s.charAt(pointer + 1))) {
					v = v * 10 + Character.getNumericValue(s.charAt(++pointer));
				}
				queue.add(Integer.toString(v));
			} else if (OPERATORS.containsKey(Character.toString(c))) {	// operators
				queue.add(Character.toString(c));
			} else if (c == '(' || c == ')') {	// parentheses
				queue.add(Character.toString(c));
			}
			
			pointer++;
		}
		
		// dequeue to a string array
		String[] tokens = new String[queue.size()];
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = queue.poll();
		}
		
		return tokens;
	}

	// convert infix notation to reverse polish notation: Shunting-yard algorithm
	private String[] toRPN(String[] tokens) {
		Queue<String> queue = new LinkedList<>();
		Stack<String> stack = new Stack<>();	// store operators
		
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			
			if (OPERATORS.containsKey(s)) {
				// pop stack to queue if the operator has same or smaller priority
				while (!stack.isEmpty() 
						&& !stack.peek().equals("(") 
						&& OPERATORS_PRIORITY.get(s) <= OPERATORS_PRIORITY.get(stack.peek())) {
					queue.add(stack.pop());
				}
				stack.push(s);	// push operator to stack
			} else if (s.equals("(")) {
				stack.push(s);	// push "(" to stack
			} else if (s.equals(")")) {
				// pop all operators between "(" and ")" to queue
				while (!stack.peek().equals("(")) {
					queue.add(stack.pop());
				}
				stack.pop();	// remove "(" from stack
			} else {
				queue.add(s);	// add number to queue
			}
		}
		
		// pop rest of operators in stack to queue
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		
		// dequeue to a string array
		String[] rpn = new String[queue.size()];
		for (int i = 0; i < rpn.length; i++) {
			rpn[i] = queue.poll();
		}
		
		return rpn;
	}

	// evaluate reverse polish notation expression
	private int evaluateRPN(String[] tokens) {
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

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		String[] infix = toStrArray(s);	// convert an expression string to a string array (infix notation)
		String[] rpn = toRPN(infix);	// convert infix notation to reverse polish notation: Shunting-yard algorithm
		
		return evaluateRPN(rpn);			// evaluate reverse polish notation expression
	}
	
	public static void main(String[] args) {
		BasicCalculatorII_E227M obj = new BasicCalculatorII_E227M();
		System.out.println(obj.calculate(null));	// -2147483648
		
		System.out.println(obj.calculate("1 + 1"));	// 2
		System.out.println(obj.calculate(" 2-1 + 2 "));	// 3
		System.out.println(obj.calculate("(1+(4+5+2)-3)+(6+8)"));	// 23
	}
}

/**
 * LeetCode #227
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. 
 * The integer division should truncate toward zero. You may assume that the given expression is always valid.
 * Some examples: "3+2*2" = 7   " 3/2 " = 1   " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */

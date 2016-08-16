package misc;

import java.util.Stack;

public class MinStack_E155E_I12M {
	/**
	 * Use two Stacks. 
	 * Time: O(1); Space: O(n)
	 */
	private Stack<Integer> stack;
	private Stack<Integer> minStack;	// always keep the min element of the current stack on its top
	
    public MinStack_E155E_I12M() {
    	stack = new Stack<>();
    	minStack = new Stack<>();
    }
    
	/**
	 * Time: O(1)
	 */
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);	// if x is smaller, then also push x into the minStack
		}
	}

	/**
	 * Time: O(1)
	 */
	public void pop() {
		if (stack.pop().equals(minStack.peek())) {
			minStack.pop();	// pop out minStack too
		}
	}
	
	/**
	 * LintCode version of pop().
	 */
	/*
	public int pop() {
		Integer n = stack.pop();
		return (n.equals(minStack.peek())) ? minStack.pop() : n;
	}
	*/

	/**
	 * Time: O(1)
	 */
	public int top() {
		return stack.peek();
	}

	/**
	 * Time: O(1)
	 */
	public int getMin() {
		 return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack_E155E_I12M obj = new MinStack_E155E_I12M();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());	// -3
		obj.pop();
		System.out.println(obj.top());	// 0
		System.out.println(obj.getMin());	// -2
	}
}

/**
 * LeetCode #155
 * LintCode #12
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

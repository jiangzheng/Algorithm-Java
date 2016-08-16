package misc;

import java.util.Stack;

public class ImplementQueueUsingStacks_E232E_I40M {
	/**
	 * Use two Stacks: 
	 * - push any new elements to stack1;
	 * - pop old elements from stack2; 
	 * - if stack2 is empty, pop all the elements in stack1 and push to stack2 one by one.
	 */
	private Stack<Integer> stack1 = new Stack<>();	// stores new elements
	private Stack<Integer> stack2 = new Stack<>();  // stores old elements

	/**
	 * Push element x to the back of queue.
	 * Time: O(1); Space: O(n)
	 */
	public void push(int x) {
		stack1.push(x);	// push new elements to stack1
	}

	/**
	 * Removes the element from in front of queue.
	 * Time: O(N); Space: O(n)
	 */
	public void pop() {
		peek();			// see peek() below
		stack2.pop();	// pop the element in stack2
		// LintCode requires returning the value of first element in this method.
		// Simply change to: int element = top(); stack2.pop(); return element;
	}

	/**
	 * Time: O(1), worst case: O(n); Space: O(n)
	 * Get the front element.
	 * In LintCode this method is called top();
	 */
	public int peek() {
		if (stack2.isEmpty()) {		// if stack2 is empty, 
			while (!stack1.isEmpty()) {		// pop all the elements in stack1 and push to stack2 one by one
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	/**
	 * Time: O(1); Space: O(n)
	 * Return whether the queue is empty.
	 */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();	// empty iff both stack1 and stack2 are empty
	}
	
	public static void main(String[] args) {
	}
}

/**
 * LeetCode #232
 * LintCode #40
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack
 *   -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. 
 * You may simulate a stack by using a list or deque (double-ended queue), 
 *   as long as you use only standard operations of a stack.
 * You may assume that all operations are valid 
 *   (for example, no pop or peek operations will be called on an empty queue).
 */

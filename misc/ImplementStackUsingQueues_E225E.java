package misc;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_E225E {
	/**
	 * Use two Queues.
	 */
	private Queue<Integer> q1 = new LinkedList<>();	// stores all elements except for the latest one
	private Queue<Integer> q2 = new LinkedList<>();	// store the latest element (only one)
	
	/**
	 * Push element x onto stack.
	 * Time: O(1); Space: O(n)
	 */
	public void push(int x) {
		q2.add(x);	// enqueue elements to q2
		while (q2.size() > 1) {	// if there're more than one elements in q2, then dequeue them to q1
			q1.add(q2.poll());
		}
	}

	/**
	 * Removes the element on top of the stack.
	 * Time: O(n); Space: O(n)
	 */
	public void pop() {
		top();	// if q1 is not empty but q2 is empty, update q2 first
		q2.poll();
	}

	/**
	 * Get the top element.
	 * Time: O(1), worst case: O(n) (if pop() is called twice); Space: O(n)
	 */
	public int top() {
		if (q2.isEmpty()) { // if q2 is empty, move the last element in q1 to q2
			for (int i = 0; i < q1.size() - 1; i++) {
				q1.add(q1.poll());
			}
			q2.add(q1.poll());
		}
		return q2.peek();
	}

	/**
	 * Return whether the stack is empty.
	 * Time: O(1); Space: O(n)
	 */
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();	// empty iff both q1 and q2 are empty
	}
	
	public static void main(String[] args) {
		ImplementStackUsingQueues_E225E obj = new ImplementStackUsingQueues_E225E();
		System.out.println(obj.empty());	// true
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.empty());	// false
		System.out.println(obj.top());	// 3
		obj.pop();
		System.out.println(obj.top());	// 2		
		obj.pop();
		System.out.println(obj.top());	// 1
		obj.pop();
		System.out.println(obj.empty());	// true
	}
}

/**
 * LeetCode #225
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue
 *   -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. 
 *   You may simulate a queue by using a list or deque (double-ended queue), 
 *   as long as you use only standard operations of a queue.
 * You may assume that all operations are valid 
 *   (for example, no pop or top operations will be called on an empty stack).
 */

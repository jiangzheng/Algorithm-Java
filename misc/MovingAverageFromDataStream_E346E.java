package misc;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream_E346E {
	/**
	 * Use a Queue to store the data stream.
	 */
	private Queue<Integer> queue;
	private int windowSize;
	private double sum;
	
	/**
	 * Constructor.
	 */
	public MovingAverageFromDataStream_E346E(int size) {
		this.queue = new LinkedList<Integer>();
		this.windowSize = size;
		this.sum = 0;
	}
	
	/**
	 * Time: O(1); Space: O(n)
	 */
	public double next(int val) {
		if (queue.size() == windowSize) {
			sum -= queue.poll();	// Retrieves and removes the head of the queue
		}
		sum += val;
		queue.offer(val);	// Inserts the new number into the queue
		
		return sum / queue.size();
	}
	
	public static void main(String[] args) {
		MovingAverageFromDataStream_E346E obj = new MovingAverageFromDataStream_E346E(3);
		System.out.println(obj.next(1));	// 1.0
		System.out.println(obj.next(10));	// 5.5
		System.out.println(obj.next(3));	// 4.666666666666667
		System.out.println(obj.next(5));	// 6.0
		System.out.println(obj.next(4));	// 4.0
		System.out.println(obj.next(6));	// 5.0
		System.out.println(obj.next(6));	// 5.333333333333333
		System.out.println(obj.next(6));	// 6.0
		System.out.println(obj.next(0));	// 4.0
		System.out.println(obj.next(0));	// 2.0
	}
}

/**
 * LeetCode #346
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example, MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1, m.next(10) = (1 + 10) / 2, m.next(3) = (1 + 10 + 3) / 3, m.next(5) = (10 + 3 + 5) / 3
 */

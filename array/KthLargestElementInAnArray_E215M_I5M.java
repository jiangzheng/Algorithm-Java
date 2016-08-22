package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_E215M_I5M {
	/**
	 * Min PQ.
	 * Given an array, the time for heap construction is O(n).
	 * The time for each heap delMin() is O(log n). 
	 * Run n - k times. (The java.util.PriorityQueue is a MinPQ.)
	 * Time: O(n + (n - k) log n); Space: O(n)
	 */
	public int findKthLargest1(int[] nums, int k) {
		if (nums == null || nums.length < k || k < 1) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length);
		
		for (int n : nums) {	// heap construction, add all numbers into the PriorityQueue
			pq.add(n);
		}
		
		int result = pq.poll();	// retrieve and remove the head of this queue (heap)
		for (int i = 0; i < nums.length - k; i++) {	// poll() n - k times
			result = pq.poll();
		}
		
		return result;
	}
	
	/**
	 * Min PQ 2.
	 * For large data or data stream, it's not suitable for maintaining a heap with size n.
	 * Use a heap with size k, insert only if the new number is greater than heap min.
	 * Time: O(k + (n - k) log k); Space: O(k)
	 */
	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length < k || k < 1) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		
		for (int i = 0; i < nums.length; i++) {
			if (i < k) {
				pq.add(nums[i]);	// add first k numbers into a PriorityQueue
			} else if (nums[i] > pq.peek()) {	// for remaining numbers, if the number > the head of this queue
				pq.poll();			// remove the head of this queue
				pq.add(nums[i]);	// add the number into the queue
			}			
		}
		
		return pq.poll();
	}
	
	/**
	 * Max PQ.
	 * Define a Comparator, such that turn java.util.PriorityQueue to a MaxPQ, delMax() k times.
	 * Time: O(n + k log n); Space: O(n)
	 */
	public int findKthLargest3(int[] nums, int k) {
		if (nums == null || nums.length < k || k < 1) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return y - x;
			}
		};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, comparator);	// define a Max PQ
		for (int n : nums) {	// heap construction, add all numbers into the PriorityQueue
			pq.add(n);
		}
		
		for (int i = 0; i < k - 1; i++) {
			pq.poll();	// retrieve and remove the head of this queue (heap)
		}
		
		return pq.poll();	// poll() k times in total
	}
	
	public static void main(String[] args) {
		int[] a = {3, 2, 1, 5, 6, 4};
		KthLargestElementInAnArray_E215M_I5M obj = new KthLargestElementInAnArray_E215M_I5M();
		System.out.println(obj.findKthLargest1(null, 2));	// -2147483648
		System.out.println(obj.findKthLargest2(null, 2));	// -2147483648
		System.out.println(obj.findKthLargest3(null, 2));	// -2147483648
		System.out.println(obj.findKthLargest1(new int[]{}, 2));	// -2147483648
		System.out.println(obj.findKthLargest2(new int[]{}, 2));	// -2147483648
		System.out.println(obj.findKthLargest3(new int[]{}, 2));	// -2147483648
		System.out.println(obj.findKthLargest1(a, 7));	// -2147483648
		System.out.println(obj.findKthLargest2(a, 7));	// -2147483648
		System.out.println(obj.findKthLargest3(a, 7));	// -2147483648
		System.out.println(obj.findKthLargest1(a, 0));	// -2147483648
		System.out.println(obj.findKthLargest2(a, 0));	// -2147483648
		System.out.println(obj.findKthLargest3(a, 0));	// -2147483648
		
		System.out.println(obj.findKthLargest1(a, 2));	// 5
		System.out.println(obj.findKthLargest2(a, 2));	// 5
		System.out.println(obj.findKthLargest3(a, 2));	// 5
	}
}

/**
 * LeetCode #215
 * LintCode #5
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 <= k <= array's length.
 */

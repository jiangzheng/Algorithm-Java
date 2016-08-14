package array;

import java.util.ArrayList;

public class RecoverRotatedSortedArray_I39E {
	/**
	 * Reverse 3 times.
	 * Time: O(n); Space: O(1)
	 */
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (nums == null) {
			return;
		}
		
		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i) > nums.get(i + 1)) {	// find the break point
				reverseList(nums, 0, i);	// reverse the first part
				reverseList(nums, i + 1, nums.size() - 1);	// reverse the second part
				reverseList(nums, 0, nums.size() - 1);	// reverse all
				return;
			}
		}
	}
	
	public void reverseList(ArrayList<Integer> nums, int from, int to) {
		while (from < to) {
			int temp = nums.get(from);
			nums.set(from++, nums.get(to));
			nums.set(to--, temp);
		}
	}
	
	public static void main(String[] args) {
		RecoverRotatedSortedArray_I39E obj = new RecoverRotatedSortedArray_I39E();
		int[] a = {4, 5, 1, 2, 3};
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int n : a) {
			l.add(n);
		}
		obj.recoverRotatedSortedArray(l);
		for (int n : l) {
			System.out.print(n + ", ");	// 1, 2, 3, 4, 5, 
		}
	}
}

/**
 * LintCode #39
 * Given a rotated sorted array, recover it to sorted array in-place.
 * Example: [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * In-place, O(1) extra space and O(n) time.
 */

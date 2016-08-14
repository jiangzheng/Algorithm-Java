package array;

import java.util.ArrayList;

public class MinimumSubarray_I44E {
	/**
	 * Compare global min, local min, and 0.
	 * Time: O(n); Space: O(1)
	 */
	public int minSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int globalMin = Integer.MAX_VALUE, currentSum = 0;
		for (int i = 0; i < nums.size(); i++) {
			int localMin = currentSum + nums.get(i);
			globalMin = (localMin < globalMin) ? localMin : globalMin;
			currentSum = (localMin < 0) ? localMin : 0;
		}
		
		return globalMin;
	}
	
	public static void main(String[] args) {
		MinimumSubarray_I44E obj = new MinimumSubarray_I44E();
		System.out.println(obj.minSubArray(null));	// -2147483648
		System.out.println(obj.minSubArray(new ArrayList<Integer>()));	// -2147483648
		
		int[] a = {1, -1, -2, 1};
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int x : a) {
			l.add(x);
		}
		System.out.println(obj.minSubArray(l));	// -3
	}
}

/**
 * LintCode #44
 * Given an array of integers, find the subarray with smallest sum.
 * Return the sum of the subarray.
 * Notice: The subarray should contain at least one integer.
 * Example: For [1, -1, -2, 1], return -3
 */

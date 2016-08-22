package dp;

import java.util.ArrayList;

public class MaximumSubarrayII_I42M {
	/**
	 * Time: O(n); Space: O(n)
	 */
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        
        return max;
	}
	
	public static void main(String[] args) {
		MaximumSubarrayII_I42M obj = new MaximumSubarrayII_I42M();
		System.out.println(obj.maxTwoSubArrays(null));	// -2147483648
		
		int[] a = {1, 3, -1, 2, -1, 2};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int x : a) {
			list.add(x);
		}
		System.out.println(obj.maxTwoSubArrays(list));	// 7
	}
}

/**
 * LintCode #42
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous. Return the largest sum.
 * Notice: The subarray should contain at least one number.
 * Example: given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], 
 *   they both have the largest sum 7.
 * Challenge: Can you do it in time complexity O(n)?
 */

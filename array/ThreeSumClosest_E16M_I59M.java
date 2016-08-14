package array;

import java.util.Arrays;

public class ThreeSumClosest_E16M_I59M {
	/**
	 * Two pointers squeeze from two ends.
	 * Time: O(n^2); Space: O(1) 
	 */
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		Arrays.sort(num);
		int closest = num[0] + num[1] + num[2];
		
		for (int i = 0; i < num.length - 2; i = increment(num, i)) {
			int low = i + 1, high = num.length - 1;
			
			while (low < high) {
				int sum = num[i] + num[low] + num[high];
				if (sum == target) {	// if a + b + c == target, return sum
					return sum;
				} else {
					if (Math.abs(target - sum) < Math.abs(target - closest)) {	// if |a+b+c-target| is smaller
						closest = sum;	// update the closest value
					}
				}
				if (sum < target) {
					low = increment(num, low);
				} else {
					high = decrement(num, high);
				}
			}
		}
		
		return closest;
	}
	
	private int increment(int[] num, int low) {
		while (low < num.length - 1 && num[low] == num[++low]) {	// find next low position
		}
		return low;
	}
		
	private int decrement(int[] num, int high) {
		while (high > 0 && num[high] == num[--high]) {	// find previous high position
		}
		return high;
	}
	
	public static void main(String[] args) {
		ThreeSumClosest_E16M_I59M obj = new ThreeSumClosest_E16M_I59M();
		System.out.println(obj.threeSumClosest(null, 1));	// -2147483648
		System.out.println(obj.threeSumClosest(new int[]{}, 1));	// -2147483648
		
		int[] a = {-1, 2, 1, -4};
		System.out.println(obj.threeSumClosest(a, 1));	// 2
	}
}

/**
 * LeetCode #16
 * LintCode #59
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

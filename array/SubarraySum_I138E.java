package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum_I138E {
	/**
	 * If the sum of [0, x] equals to the sum of [0, y], then the sum of (x, y] is 0.
	 * Time: O(n); Space: O(n)
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();	// <sum, position>
		map.put(0, -1);
		int sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (!map.containsKey(sum)) {	// new sum
				map.put(sum, i);
			} else {	// saw this sum before
				list.add(map.get(sum) + 1);	// start position
				list.add(i);	// end position
				return list;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		SubarraySum_I138E obj = new SubarraySum_I138E();
		int[] a = {-3, 1, 2, -3, 4};
		int[] b = {};
		int[] c = {0};
		int[] d = {1};
		System.out.println(obj.subarraySum(a));	// [0, 2]
		System.out.println(obj.subarraySum(b));	// null
		System.out.println(obj.subarraySum(c));	// [0, 0]
		System.out.println(obj.subarraySum(d));	// []
	}
}

/**
 * LintCode #138
 * Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
 * Notice: There is at least one subarray that it's sum equals to zero.
 * Example: Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */

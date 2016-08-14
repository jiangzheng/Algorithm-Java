package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_E1M_I56M {
	/**
	 * Use Map to store <number, index>.
	 * Time: O(n); Space: O(n)
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;	// invalid input
		}
		
		Map<Integer, Integer> map = new HashMap<>();	// <number, index>
		
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (!map.containsKey(diff)) {	// see if the map containsKey(target - nums[i])
				map.put(nums[i], i);	// if not, put <nums[i], i> into map
			} else {
				return new int[] {map.get(diff), i};	// if yes, return indices (starting from 1 instead of 0)
				// LintCode: return new int[] {map.get(diff) + 1, i + 1};
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		TwoSum_E1M_I56M obj = new TwoSum_E1M_I56M();
		System.out.println(obj.twoSum(null, 9));	// null
		System.out.println(obj.twoSum(new int[]{}, 9));	// null
		
		int[] a = {7, 15, 2, 11};
		int[] result = obj.twoSum(a, 9);
		for (int n : result) {
			System.out.print(n + ", ");	// 0, 2, // LintCode: 1, 3, 
		}
		
		System.out.println("\n" + obj.twoSum(a, 10));	// null
	}
}

/**
 * LeetCode #1
 * LintCode #56
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */

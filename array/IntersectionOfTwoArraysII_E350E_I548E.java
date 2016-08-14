package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII_E350E_I548E {
	/**
	 * Use Map.
	 * Time: O(n); Space: O(n)
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int n: nums1) {
			if (!map.containsKey(n)) {
				map.put(n, 1);
			} else {
				map.put(n, map.get(n) + 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int n : nums2) {
			if (map.containsKey(n)) {
				list.add(n);	// n is in the intersection
				if (map.get(n) > 1) {
					map.put(n, map.get(n) - 1);	// matched once
				} else {
					map.remove(n);	// no more to match
				}
			}
		}
		
		int[] intersection = new int[list.size()];
		int i = 0;
		for (int n: list) {
			intersection[i++] = n;
		}
		
		return intersection;
	}
	
	public static void main(String[] args) {
		IntersectionOfTwoArraysII_E350E_I548E obj = new IntersectionOfTwoArraysII_E350E_I548E();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		System.out.println(obj.intersect(null, null));	// null
		System.out.println(obj.intersect(null, nums2));	// null
		System.out.println(obj.intersect(nums1, null));	// null
		
		int[] result = obj.intersect(nums1, nums2);
		for (int n : result) {
			System.out.print(n + ", ");	// 2, 2, 
		}

	}
}

/**
 * LeetCode #350
 * LintCode #548
 * Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note: 
 * - Each element in the result should appear as many times as it shows in both arrays.
 * - The result can be in any order.
 * Follow up:
 * - What if the given array is already sorted? How would you optimize your algorithm?
 * - What if nums1's size is small compared to num2's size? Which algorithm is better?
 * - What if elements of nums2 are stored on disk, 
 *   and the memory is limited such that you cannot load all elements into the memory at once?
 */

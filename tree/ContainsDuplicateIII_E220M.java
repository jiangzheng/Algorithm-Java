package tree;

import java.util.TreeSet;

public class ContainsDuplicateIII_E220M {
	/**
	 * BST + Slide Window.
	 * Time: O(n log k); Space: O(k)
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k < 1 || t < 0) {
			return false;	// invalid input
		}

		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			if (set.floor(c) != null && set.floor(c) >= c - t
			 || set.ceiling(c) != null && set.ceiling(c) <= c + t) {
				return true;
			} else {
				set.add(c);
				if (i >= k) {
					set.remove(nums[i - k]);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateIII_E220M obj = new ContainsDuplicateIII_E220M();
		int[] a = {1, 2, 3};
		System.out.println(obj.containsNearbyAlmostDuplicate(null, 2, 1));	// false
		System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{}, 2, 1));	// false
		System.out.println(obj.containsNearbyAlmostDuplicate(a, 0, 1));	// false
		System.out.println(obj.containsNearbyAlmostDuplicate(a, 2, -1));	// false
		
		System.out.println(obj.containsNearbyAlmostDuplicate(a, 2, 1));	// true
	}
}

/**
 * LeetCode #220
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 *   such that the difference between nums[i] and nums[j] is at most t 
 *   and the difference between i and j is at most k.
 */

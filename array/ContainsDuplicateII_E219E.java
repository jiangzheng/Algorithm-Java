package array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII_E219E {
	/**
	 * Use HashMap.
	 * Time: O(n); Space: O(n)
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k <= 0) {
			return false;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {	// if not a duplicate, put (nums[i], i) into the HashMap
				map.put(nums[i], i);
			} else if (i - map.get(nums[i]) <= k) {	// if a duplicate, and if the index difference is at most k, return true
				return true;
			} else {				// if a duplicate, but the index difference is > k
				map.put(nums[i], i);		// replaces the previous value associated with the given key in the map
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicateII_E219E obj = new ContainsDuplicateII_E219E();
		int[] A = {1, 2, 3, 2, 1};
		System.out.println(obj.containsNearbyDuplicate(null, 1));	// false
		System.out.println(obj.containsNearbyDuplicate(new int[]{}, 1));	// false
		System.out.println(obj.containsNearbyDuplicate(new int[]{1}, 1));	// false
		System.out.println(obj.containsNearbyDuplicate(A, -1));	// false
		System.out.println(obj.containsNearbyDuplicate(A, 0));	// false
		System.out.println(obj.containsNearbyDuplicate(A, 1));	// false
		System.out.println(obj.containsNearbyDuplicate(A, 2));	// true
	}
}

/**
 * LeetCode #219
 * Given an array of integers and an integer k, 
 *   find out whether there are two distinct indices i and j in the array 
 *   such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

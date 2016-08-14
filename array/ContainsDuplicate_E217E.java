package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_E217E {
	/**
	 * Utilize HashSet which does not allow duplication.
	 * Time: O(n); Space: O(n) 
	 */
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;		// if the set contains this number, return true
			} else {
				set.add(nums[i]);	// otherwise add this number into the set
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ContainsDuplicate_E217E obj = new ContainsDuplicate_E217E();
		int[] a = { 1, 2, 4, 5, 6, 2 };
		int[] b = { 1, 2, 4, 5, 6, 7 };
		System.out.println(obj.containsDuplicate(null));	// false
		System.out.println(obj.containsDuplicate(new int[]{}));	// false
		System.out.println(obj.containsDuplicate(new int[]{1}));	// false
		System.out.println(obj.containsDuplicate(a));	// true
		System.out.println(obj.containsDuplicate(b));	// false
	}
}

/**
 * LeetCode #217
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 *   and it should return false if every element is distinct.
 */

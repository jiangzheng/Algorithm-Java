package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays_E349E_I547E {
	/**
	 * Use two Sets.
	 * Time: O(n); Space: O(n)
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int n: nums1) {
			set1.add(n);
		}
		for (int n: nums2) {
			set2.add(n);
		}
		
		Iterator<Integer> iterator = set1.iterator();
		while (iterator.hasNext()) {
			if (!set2.contains(iterator.next())) {
				iterator.remove();
			}
		}
		
		int[] intersection = new int[set1.size()];
		int i = 0;
		for (int n: set1) {
			intersection[i++] = n;
		}

		return intersection;
	}
	
	public static void main(String[] args) {
		IntersectionOfTwoArrays_E349E_I547E obj = new IntersectionOfTwoArrays_E349E_I547E();
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		System.out.println(obj.intersection(null, null));	// null
		System.out.println(obj.intersection(null, nums2));	// null
		System.out.println(obj.intersection(nums1, null));	// null
		
		int[] result = obj.intersection(nums1, nums2);
		for (int n : result) {
			System.out.print(n + ", ");	// 2, 
		}
	}
}

/**
 * LeetCode #349
 * LintCode #547
 * Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note: Each element in the result must be unique. The result can be in any order.
 */

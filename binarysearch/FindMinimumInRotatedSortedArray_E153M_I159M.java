package binarysearch;

public class FindMinimumInRotatedSortedArray_E153M_I159M {
	/**
	 * Binary search.
	 * Time: O(log n); Space: O(1)
	 */
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int low = 0, high = nums.length - 1;
		
		// when nums[low] <= nums[high] (no rotation in this section), stop loop and return nums[low]
		while (low < high && nums[low] > nums[high]) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] <= nums[high]) {	// 7 0 1 2 4 5 6, move high to middle
				high = middle;
			} else {	// 2 4 5 6 7 0 1, move low to middle + 1
				low = middle + 1;
			}
		}
		
		return nums[low];
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray_E153M_I159M obj = new FindMinimumInRotatedSortedArray_E153M_I159M();
		System.out.println(obj.findMin(null));	// -2147483648
		System.out.println(obj.findMin(new int[]{}));	// -2147483648
		
		int[] a = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(obj.findMin(a));	// 0
	}
}

/**
 * LeetCode #153
 * LintCode #159
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

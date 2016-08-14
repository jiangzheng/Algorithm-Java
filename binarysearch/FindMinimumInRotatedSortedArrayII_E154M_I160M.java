package binarysearch;

public class FindMinimumInRotatedSortedArrayII_E154M_I160M {
	/**
	 * Binary search.
	 * Time: O(log n), worst case: O(n); Space: O(1)
	 */
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int low = 0, high = nums.length - 1;
		
		// when nums[low] < nums[high] (no rotation in this section), stop loop and return nums[low]
		while (low < high && nums[low] >= nums[high]) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] < nums[high]) {	// 7,7,0,0,0,1,2,2,4,4,5,6,6,6,6, move high to middle
				high = middle;
			} else if (nums[middle] > nums[high]) {	// 4,4,5,6,6,6,6,7,7,0,0,0,1,2,2, move low to middle + 1
				low = middle + 1;
			} else {	// nums[middle] == nums[low] or nums[middle] == nums[high] 7,7,0,0,0,1,2,2,2,2,2,2,2,2,2,
				high--;	// low++ is correct too
			}
		}
		
		return nums[low];
	}
	
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII_E154M_I160M obj = new FindMinimumInRotatedSortedArrayII_E154M_I160M();
		System.out.println(obj.findMin(null));	// -2147483648
		System.out.println(obj.findMin(new int[]{}));	// -2147483648
		
		int[] a = {4, 4, 5, 6, 6, 6, 6, 7, 7, 0, 0, 0, 1, 2, 2};
		System.out.println(obj.findMin(a));	// 0
	}
}

/**
 * LeetCode #154
 * LintCode #160
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. The array may contain duplicates.
 */

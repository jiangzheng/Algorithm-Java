package binarysearch;

public class SearchInRotatedSortedArrayII_E81M_I63M {
	/**
	 * Binary Search.
	 * Time: O(log n), worst case: O(n); Space: O(1)
	 */
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;	// invalid input
		}
		
		int low = 0, high = nums.length - 1;
		
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] == target) {
				return true;
			}
			
			if (nums[middle] < nums[high]) {	// [middle..high] is in order
				if (nums[middle] < target && target <= nums[high]) {
					low = middle + 1;
				} else {
					high = middle;
				}
			} else if (nums[middle] > nums[high]) {	// [low..middle] is in order
				if (nums[low] <= target && target < nums[middle]) {
					high = middle;
				} else {
					low = middle + 1;
				}
			} else {	// add this part for the duplicated case, i.e., nums[middle] == nums[high]
				high--;	// cannot high = middle, might miss bigger number in [middle..high]. e.g., [1,1,3,1], target = 3
			}
		}
		
		return (nums[low] == target) ? true : false;
	}
	
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII_E81M_I63M obj = new SearchInRotatedSortedArrayII_E81M_I63M();
		System.out.println(obj.search(null, 1));	// false
		System.out.println(obj.search(new int[]{}, 1));	// false
		
		int a[] = {4,5,5,5,6,7,7,0,0,1,2,2,2};
		System.out.println(obj.search(a, 1));	// true
		System.out.println(obj.search(a, 5));	// true
		System.out.println(obj.search(a, 3));	// false
	}
}

/**
 * LeetCode #81
 * LintCode #63
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */

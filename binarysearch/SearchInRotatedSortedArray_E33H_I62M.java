package binarysearch;

public class SearchInRotatedSortedArray_E33H_I62M {
	/**
	 * Binary Search.
	 * Time: O(log n); Space: O(1) 
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;	// invalid input
		}
		
		int low = 0, high = nums.length - 1;
		
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] == target) {
				return middle;
			}
			
			if (nums[middle] < nums[high]) {	// [middle..high] is in order  7,0,1,2,4,5,6
				if (nums[middle] < target && target <= nums[high]) {	// nums[middle] < target <= nums[high]  e.g., = 4
					low = middle + 1;	// target is in [middle..high]
				} else {	// target = 1 or 7
					high = middle;	// target is in [low..middle]
				}
			} else {	// [low..middle] is in order  2,4,5,6,7,0,1
				if (nums[low] <= target && target < nums[middle]) {	// nums[low] <= target < nums[middle]  e.g., = 5
					high = middle;	// target is in [low..middle]
				} else {	// target = 1 or 7
					low = middle + 1;	// target is in [middle..high]
				}
			}
		}
		
		return (nums[low] == target) ? low : -1;
	}
	
	public static void main(String[] args) {
		SearchInRotatedSortedArray_E33H_I62M obj = new SearchInRotatedSortedArray_E33H_I62M();;
		System.out.println(obj.search(null, 1));	// -1
		System.out.println(obj.search(new int[]{}, 1));	// -1
		
		int[] a = {4,5,6,7,0,1,2};
		System.out.println(obj.search(a, 1));	// 5
	}
}

/**
 * LeetCode #33
 * LintCode #62
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

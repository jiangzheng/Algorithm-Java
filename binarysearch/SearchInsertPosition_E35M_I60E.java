package binarysearch;

public class SearchInsertPosition_E35M_I60E {
	/**
	 * Binary Search.
	 * Time: O(log n); Space: O(1)
	 */
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int low = 0, high = nums.length - 1;
		
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] > target) {	// 1,2,3,4,5,6,7  2, move high to middle
				high = middle;
			} else if (nums[middle] < target) {	// 1,2,3,4,5,6,7  6, move low to middle + 1
				low = middle + 1;
			} else {
				return middle;	// find the target
			}
		}
		
		return (nums[low] >= target) ? low : low + 1;
	}
	
	public static void main(String[] args) {
		SearchInsertPosition_E35M_I60E obj = new SearchInsertPosition_E35M_I60E();
		int[] a = { 1, 3, 5, 6 };
		System.out.println(obj.searchInsert(a, 5));	//2
		System.out.println(obj.searchInsert(a, 2));	//1
		System.out.println(obj.searchInsert(a, 7));	//4
		System.out.println(obj.searchInsert(a, 0));	//0
	}
}

/**
 * LeetCode #35
 * LintCode #60
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 */

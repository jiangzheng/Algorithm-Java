package binarysearch;

public class SearchForARange_E34M_I61M {
	/**
	 * Binary Search.
	 * Time: O(log n); Space: O(1)
	 */
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};	// invalid input
		}
		
		// find the leftmost match
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] >= target) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		if (nums[low] != target) {
			return new int[]{-1, -1};	// no match is found
		}
		int from = low;
		
		// find the rightmost match
		high = nums.length - 1;
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] > target) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		int to = (nums[high] != target) ? high - 1 : high;	// if no match on high, need to move backward one step
		
		return new int[]{from, to};
	}
	
	private void printResult(int[] result) {
		System.out.print("[");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i != result.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
	}
	
	public static void main(String[] args) {
		SearchForARange_E34M_I61M obj = new SearchForARange_E34M_I61M();
		obj.printResult(obj.searchRange(null, 8));	// [-1, -1]
		obj.printResult(obj.searchRange(new int[]{}, 8));	// [-1, -1]
		
		int[] a = {5,7,7,8,8,10};
		int[] b = {8,8,9,9,9,10};
		obj.printResult(obj.searchRange(a, 6));	// [-1, -1]
		obj.printResult(obj.searchRange(a, 8));	// [3, 4]
		obj.printResult(obj.searchRange(b, 8));	// [0, 1]
		obj.printResult(obj.searchRange(b, 10));	// [5, 5]
	}
}

/**
 * LeetCode #34
 * LintCode #61
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */

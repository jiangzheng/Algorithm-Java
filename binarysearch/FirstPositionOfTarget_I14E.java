package binarysearch;

public class FirstPositionOfTarget_I14E {
	/**
	 * Binary search.
	 * Time: O(log n); Space: O(1)
	 */
	public int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int low = 0, high = nums.length - 1;
		
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			if (nums[middle] >= target) {	// 1,2,3,4,5,6,7  2, move high to middle
				high = middle;
			} else {	// 1,2,3,4,5,6,7  6, move low to middle + 1
				low = middle + 1;
			}
		}
		
		return (nums[low] == target) ? low : -1;
	}
	
	public static void main(String[] args) {
		FirstPositionOfTarget_I14E obj = new FirstPositionOfTarget_I14E();
		int[] a = {1, 2, 3, 3, 4, 5, 10};
		int[] b = {1, 2, 3, 3, 3, 3, 4, 5, 10};
		int[] c = {1, 2, 3, 4, 5, 10};
		System.out.println(obj.binarySearch(a, 3));	// 2
		System.out.println(obj.binarySearch(b, 3));	// 2
		System.out.println(obj.binarySearch(c, 3));	// 2
	}
}

/**
 * LintCode #14
 * For a given sorted array (ascending order) and a target number, 
 *   find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * Example: If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 */

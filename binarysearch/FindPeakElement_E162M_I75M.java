package binarysearch;

public class FindPeakElement_E162M_I75M {
	/**
	 * Binary Search.
	 * Because no duplication, so only 4 cases, and only a) is peak:
	 * a)      b)*     c)    * d)
	 *    (*)     (*)     (*)    *   *
	 *   *   *       *   *        (*)
	 * If mid < right (i.e., case c & d), then there must be a peak on the right of mid
	 * If mid < left (i.e., case b & d), then there must be a peak on the left of mid
	 * Otherwise, mid is peak (i.e., case a)
	 * Time: O(log n); Space: O(1) 
	 */
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int low = 0, high = nums.length - 1;
		
		while (low <= high) {	// instead of low < high, b/c when low=high=middle, still need to tell if it is peak
			int middle = (low + high) / 2;	// binary split
			if (middle > 0 && nums[middle] < nums[middle - 1]) {	// 1,4,3,2,1, middle < left, move high to middle
				high = middle;
			} else if (middle < nums.length - 1 && nums[middle] < nums[middle + 1]) {	// 1,2,3,1, middle < right, move low to middle + 1
				low = middle + 1;
			} else {
				return middle;	// middle > both left and right
			}
		}
		
		return -1;	// peak doesn't exist
	}
	
	public static void main(String[] args) {
		FindPeakElement_E162M_I75M obj = new FindPeakElement_E162M_I75M();
		int[] a = { 1, 2, 3, 1 };
		int[] b = { 1, 2, 1, 3, 4, 5, 7, 6 };
		System.out.println(obj.findPeakElement(a));	// 2
		System.out.println(obj.findPeakElement(b));	// 6
	}
}

/**
 * LeetCode #162
 * LintCode #75
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] != num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -infinite.
 * For example, in array [1, 2, 3, 1], 3 is a peak element 
 *   and your function should return the index number 2.
 * Note: Your solution should be in logarithmic complexity.
 */

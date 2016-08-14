package array;

public class RemoveDuplicatesFromSortedArray_E26E_I100E {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int pointer = 1;	// point to the first duplicated element
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[pointer++] = nums[i];	// replace duplicated elements with distinct elements
			}
		}
		
		return pointer;
	}
	
	/**
	 * Slight modification, can generalize to the case of keeping at most two elements.
	 * Initial: pos = 0, i = 1;
	 * If A[i] == A[pos], skip A[i] by i++;
	 * If A[i] != A[pos], keep A[i] by A[++pos] = A[i].
	 * Time: O(N); Space: O(1) 
	 */
	/*
	public int removeDuplicates2(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int pos = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[pos])
				nums[++pos] = nums[i];
		}
		return pos + 1;
	}
	*/
	
	/**
	 * Same algorithm, only difference is to count the number of duplicates instead of number of unique elements.
	 * Time: O(N); Space: O(1) 
	 */
	/*
	public int removeDuplicates3(int[] nums) {
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - count - 1]) {
				count++;
			} else if (count > 0) {
				nums[i - count] = nums[i];
			}
		}
		return nums.length - count;
	}
	*/
	
	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2, 3 };
		int[] B = { 1, 1, 2, 2, 3 };
		RemoveDuplicatesFromSortedArray_E26E_I100E obj = new RemoveDuplicatesFromSortedArray_E26E_I100E();
		System.out.println(obj.removeDuplicates(A));	// 3
		System.out.println(obj.removeDuplicates(B));	// 3
	}
}

/**
 * LeetCode #26
 * Lintcode #100
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 *   and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 * It doesn't matter what you leave beyond the new length.
 */

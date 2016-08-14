package array;

public class MoveZeroes_E283E_I539E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int pointer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {		// skip 0s
				if (pointer != i) {		// no need to move if pointer and i point to the same element
					nums[pointer] = nums[i];	// move non-zero elements as left as possible
					nums[i] = 0;
				}
				pointer++;
			}
		}
		
		for (int i = pointer; i < nums.length; i++) {	// make up 0s
			nums[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		MoveZeroes_E283E_I539E obj = new MoveZeroes_E283E_I539E();
		int[] nums = {0, 1, 0, 3, 12};
		obj.moveZeroes(nums);
		for (int x : nums) {
			System.out.print(x + ", ");	// 1, 3, 12, 0, 0, 
		}
	}
}

/**
 * LeetCode #283
 * LeetCode #539
 * Given an array nums, write a function to move all 0's to the end of it 
 *   while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note: You must do this in-place without making a copy of the array. Minimize the total number of operations.
 */

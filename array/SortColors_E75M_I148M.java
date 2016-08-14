package array;

public class SortColors_E75M_I148M {
	/**
	 * Radix sort (two-pass). 0: red, 1: white, 2: blue.
	 * Time: O(2n); Space: O(1) 
	 */
	public int[] sortColors1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;	// invalid input
		}
		
		int[] count = new int[3];
		for (int n : nums) {
			count[n]++;
		}
		
		int pointer = 0;
		for (int i = 0; i < count[0]; i++) {
			nums[pointer++] = 0;
		}
		for (int i = 0; i < count[1]; i++) {
			nums[pointer++] = 1;
		}
		for (int i = 0; i < count[2]; i++) {
			nums[pointer++] = 2;
		}
		
		return nums;
	}
	
	/**
	 * 3 pointers (squeeze & swap) (one-pass).
	 * Time: O(n); Space: O(1)
	 */
	public int[] sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;	// invalid input
		}
		
		int pointer = 0, red = 0, blue = nums.length - 1;
		
		while (pointer <= blue) {
			if (nums[pointer] == 0) {	// if red
				swap(nums, pointer++, red++);
			} else if (nums[pointer] == 2) {	// if blue
				swap(nums, pointer, blue--);	// don't forward pointer b/c it might be red now (by switched), check pointer again
			} else {
				pointer++;	// if white
			}
		}
		
		return nums;
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void main(String[] args) {
		SortColors_E75M_I148M obj = new SortColors_E75M_I148M();
		System.out.println(obj.sortColors1(null));	// null
		System.out.println(obj.sortColors2(null));	// null
		System.out.println(obj.sortColors1(new int[]{}));	// null
		System.out.println(obj.sortColors2(new int[]{}));	// null
		
		int[] a = {1, 1, 0, 2, 0};
		int[] result = obj.sortColors1(a);
		for (int x : result) {
			System.out.print(x + ", ");	// 0, 0, 1, 1, 2, 
		}
		System.out.print("\n");
		result = obj.sortColors2(a);
		for (int x : result)
			System.out.print(x + ", ");	// 0, 0, 1, 1, 2, 
	}
}

/**
 * LeetCode #75
 * LintCode #148
 * Given an array with n objects colored red, white or blue, 
 *   sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 *   then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */

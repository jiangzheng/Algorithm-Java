package bit;

public class MissingNumber_E268M_I196M {
	/**
	 * Bit manipulation.
	 * XOR 1, 2, ..., n, and all numbers in nums, the result (remaining) is the missing number.
	 * Time: O(n); Space: O(1)
	 */
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;	// invalid input
		}
		
		int missingNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			missingNumber ^= (i + 1) ^ nums[i];
		}
		
		return missingNumber;
	}
	
	public static void main(String[] args) {
		MissingNumber_E268M_I196M obj = new MissingNumber_E268M_I196M();
		System.out.println(obj.missingNumber(null));	// -1
		System.out.println(obj.missingNumber(new int[]{}));	// -1
		
		int[] a = {0, 1, 3};
		System.out.println(obj.missingNumber(a));	// 2
	}
}

/**
 * LeetCode #268
 * LintCode #196
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 *   find the one that is missing from the array.
 * For example, Given nums = [0, 1, 3] return 2.
 * Note: Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 */

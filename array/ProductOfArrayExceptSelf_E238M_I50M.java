package array;

import java.util.ArrayList;

public class ProductOfArrayExceptSelf_E238M_I50M {
	/**
	 * LeetCode version.
	 * Time: O(n); Space: O(1)
	 */
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;	// invalid input
		}
		
		int[] result = new int[nums.length];
		
		result[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}
		
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left = left * nums[i];
		}
	
		return result;
	}
	
	/**
	 * LintCode version.
	 */
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
		return null;
	}
	
	public static void main(String[] args) {
		ProductOfArrayExceptSelf_E238M_I50M obj = new ProductOfArrayExceptSelf_E238M_I50M();
		System.out.println(obj.productExceptSelf(null));	// null
		System.out.println(obj.productExceptSelf(new int[]{}));	// null
		
		int[] a = {1, 2, 3, 4};
		int[] result = obj.productExceptSelf(a);
		for (int x : result) {
			System.out.print(x + ", ");	// 24, 12, 8, 6, 
		}
	}
}

/**
 * LeetCode #238
 * LintCode #50
 * Given an array of n integers where n > 1, nums, 
 *   return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up: Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * Given an integers array A.
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 * Example: For A = [1, 2, 3], return [6, 3, 2].
 */

package dp;

public class MaximumProductSubarray_E152M_I191M {
	/**
	 * 1-d DP.
	 * maxProd: the largest product of the subarray ending at nums[i].
	 * minProd: the smallest product of the subarray ending at nums[i].
	 * Time: O(n); Space: O(1)
	 */
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int maxProd = 1, minProd = 1;	// due to negative numbers, both max product and min product need to be calculated
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			int tempMaxProd = maxProd;
			maxProd = Math.max(Math.max(maxProd * nums[i], nums[i]), minProd * nums[i]);
			minProd = Math.min(Math.min(minProd * nums[i], nums[i]), tempMaxProd * nums[i]);
			max = Math.max(max, maxProd);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MaximumProductSubarray_E152M_I191M obj = new MaximumProductSubarray_E152M_I191M();
		System.out.println(obj.maxProduct(null));	// -2147483648
		System.out.println(obj.maxProduct(new int[]{}));	// -2147483648
		
		int[] a = {2, 3, -2, 4};
		System.out.println(obj.maxProduct(a));	// 6
	}
}

/**
 * LeetCode #152
 * LintCode #191
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */

/**
 * Let f(i) be the largest product of the subarray ending at A[i].
 * Let g(i) be the smallest product of the subarray ending at A[i].
 * f(i) = max{f(i - 1) * A[i], A[i], g(i - 1) * A[i]}
 * g(i) = min{f(i - 1) * A[i], A[i], g(i - 1) * A[i]}
 * Use maxProd and minProd to store f(i) and g(i) at each i, respectively.
 * Use max and min to store the largest f(i) and the smallest g(i), respectively.
 */

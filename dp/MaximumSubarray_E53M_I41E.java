package dp;

public class MaximumSubarray_E53M_I41E {
	/**
	 * 1-d DP.
	 * d(i): the largest sum of the subarray ending at nums[i]. 
	 * d(i) = max{ d(i - 1) + nums[i], nums[i] }
	 * Time: O(n); Space: O(1)
	 */
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int sum = 0, max = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);	// sum: store d(i) at each i
			max = Math.max(sum, max);	// max: store the largest d(i) over the array
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		MaximumSubarray_E53M_I41E obj = new MaximumSubarray_E53M_I41E();
		System.out.println(obj.maxSubArray(null));	// -2147483648
		System.out.println(obj.maxSubArray(new int[]{}));	// -2147483648
		
		int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(obj.maxSubArray(a));	// 6
	}
}

/**
 * LeetCode #53
 * LintCode #41
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4]
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
 *   which is more subtle.
 */

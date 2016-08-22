package dp;

public class MaximumSubarrayIII_I43H {
	/**
	 * Time: O(n); Space: O(n)
	 */
	public int maxSubArray(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		if (nums.length < k) {
			return 0;
		}
   
		int[][] globalMax = new int[k + 1][nums.length + 1];
		int[][] localMax = new int[k + 1][nums.length + 1];
		
		for (int i = 1; i <= k; i++) {
			localMax[i][i-1] = Integer.MIN_VALUE;
			for (int j = i; j <= nums.length; j++) {
				localMax[i][j] = Math.max(localMax[i][j-1], globalMax[i - 1][j-1]) + nums[j-1];
				if (j == i) {
					globalMax[i][j] = localMax[i][j];
				} else {
					globalMax[i][j] = Math.max(globalMax[i][j-1], localMax[i][j]);
				}
			}
		}
		
		return globalMax[k][nums.length];
	}
	
	public static void main(String[] args) {
		int[] a = {-1, 4, -2, 3, -2, 3};
		
		MaximumSubarrayIII_I43H obj = new MaximumSubarrayIII_I43H();
		System.out.println(obj.maxSubArray(null, 2));	// -2147483648
		System.out.println(obj.maxSubArray(a, 0));	// -2147483648
		
		System.out.println(obj.maxSubArray(a, 2));	// 8
	}
}

/**
 * LintCode #43
 * Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous. Return the largest sum.
 * Notice: The subarray should contain at least one number.
 * Example: Given [-1,4,-2,3,-2,3], k=2, return 8
 */

package dp;

public class MaximumSubarrayDifference_I45M {
	/**
	 * Time: O(n); Space: O(n)
	 */
	public int maxDiffSubArrays(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
        int[] left_max = new int[nums.length];
        int[] left_min = new int[nums.length];
        int[] right_max = new int[nums.length];
        int[] right_min = new int[nums.length];
        int[] copy = new int[nums.length];
        
        /*Get negative copy*/
        for(int i = 0; i < nums.length; i++){
            copy[i] = -1 * nums[i];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        
        /*Forward: get max subarray*/
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_max[i] = max;
        }
        
        /*Backward: get max subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_max[i] = max;
        }
        
        /*Forward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_min[i] = -1 * max;
        }
        
        /*Backward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_min[i] = -1 * max;
        }
        
        int diff = 0;
        for(int i = 0; i < nums.length - 1; i++){
            diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
            diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
        }
        
        return diff;
	}
	
	public static void main(String[] args) {
		MaximumSubarrayDifference_I45M obj = new MaximumSubarrayDifference_I45M();
		System.out.println(obj.maxDiffSubArrays(null));	// -2147483648
		System.out.println(obj.maxDiffSubArrays(new int[]{}));	// -2147483648
		
		int[] a = {1, 2, -3, 1};
		System.out.println(obj.maxDiffSubArrays(a));	// 6
	}
}

/**
 * LintCode #45
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 * Notice: The subarray should contain at least one number
 * Example, For [1, 2, -3, 1], return 6.
 * O(n) time and O(n) space.
 */

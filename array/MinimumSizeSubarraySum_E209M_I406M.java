package array;

public class MinimumSizeSubarraySum_E209M_I406M {
	/**
	 * Two Pointers.
	 * The fast pointer scans forward. When sum >= s, move slow pointer prev until sum < s.
	 * Record the shortest length of the subarray.
	 * Time: O(n); Space: O(1)
	 */
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0 || s < 1) {
			return -1;	// invalid input
		}
		
		int prev = 0, sum = 0, length = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				length = Math.min(length, i - prev + 1);
				sum -= nums[prev++];
			}
		}
		
		return length == Integer.MAX_VALUE ? 0 : length;
	}
	

	public static void main(String[] args) {
		MinimumSizeSubarraySum_E209M_I406M obj = new MinimumSizeSubarraySum_E209M_I406M();
		System.out.println(obj.minSubArrayLen(7, null));	// -1
		System.out.println(obj.minSubArrayLen(7, new int[]{}));	// -1
		
		int[] a = {2, 3, 1, 2, 4, 3};
		System.out.println(obj.minSubArrayLen(7, a));	// 2
		System.out.println(obj.minSubArrayLen(15, a));	// 6
		System.out.println(obj.minSubArrayLen(16, a));	// 0
	}
}

/**
 * LeetCode #209
 * LintCode #406
 * Given an array of n positive integers and a positive integer s, 
 *   find the minimal length of a subarray of which the sum >= s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 *   the subarray [4,3] has the minimal length under the problem constraint.
 * More practice:
 * If you have figured out the O(n) solution, 
 *   try coding another solution of which the time complexity is O(n log n).
 */

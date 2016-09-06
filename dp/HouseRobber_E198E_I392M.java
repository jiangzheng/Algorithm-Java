package dp;

public class HouseRobber_E198E_I392M {
	/**
	 * 1-d DP.
	 * d(i): the max money that the robber can get from house 0 to i.
	 * d(i) = max{ d(i - 1), d(i - 2) + nums[i] }
	 * Time: O(n); Space: O(n)
	 */
	public long rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;	// invalid input
		}
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		long[] d = new long[nums.length];
		d[0] = nums[0];
		d[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);	// d(i) = max{ d(i - 1), d(i - 2) + nums[i] }
		}
		
		return d[nums.length - 1];
	}
		
	public static void main(String[] args) {
		HouseRobber_E198E_I392M obj = new HouseRobber_E198E_I392M();
		System.out.println(obj.rob(null))	// 0
		System.out.println(obj.rob(new int[]{}))	// 0
		
		int[] a = {1, 1, 3, 2, 1};
		System.out.println(obj.rob(a));	// 5
	}
}

/**
 * LeetCode #198
 * LintCode #392
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 *   the only constraint stopping you from robbing each of them is that 
 *   adjacent houses have security system connected and it will automatically contact the police 
 *   if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 *   determine the maximum amount of money you can rob tonight without alerting the police.
 */

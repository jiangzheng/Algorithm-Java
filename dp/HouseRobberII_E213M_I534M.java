package dp;

public class HouseRobberII_E213M_I534M {
	/**
	 * 1-d DP.
	 * d(i): the max money that the robber can get from house 0 to i.
	 * Time: O(2n); Space: O(n)
	 */
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;	// invalid input
		}
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		// 1) if nums[0] is robbed, then nums[1] and nums[n - 1] can't be robbed, so max1 = nums[0] + max of nums[2 ~ n - 2]
		int max1 = nums[0] + dp(nums, 2, nums.length - 2);
		// 2) if nums[0] is not robbed, then nums[1] and nums[n - 1] can be robbed, so max2 = max of nums[1 ~ n - 1]
		int max2 = dp(nums, 1, nums.length - 1);
		
		return Math.max(max1, max2);
	}
	
	private int dp(int[] nums, int from, int to) {	// similar to HouseRobber_E198E_I392M.rob(int[] nums)
		if (from > to) {
			return 0;
		}
		
		if (from == to) {
			return nums[from];
		}
		
		int[] d = new int[nums.length];
		d[from] = nums[from];	// e.g., d[0] = nums[0];
		d[from + 1] = Math.max(nums[from], nums[from + 1]);	// e.g., d[1] = Math.max(nums[0], nums[1]);
		for (int i = from + 2; i <= to; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);	// d(i) = max{ d(i - 1), d(i - 2) + nums[i] };
		}
		
		return d[to];
	}
	
	public static void main(String[] args) {
		HouseRobberII_E213M_I534M obj = new HouseRobberII_E213M_I534M();
		System.out.println(obj.rob(null));	// 0
		System.out.println(obj.rob(new int[]{}));	// 0
		
		int[] a = {1, 1, 3, 2, 1};
		System.out.println(obj.rob(a));	// 4
	}
}

/**
 * LeetCode #213
 * LintCode #534
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, 
 *   the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 *   determine the maximum amount of money you can rob tonight without alerting the police.
 */

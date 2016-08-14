package array;

public class JumpGame_E55M_I116M {
	/**
	 * Greedy algorithm.
	 * Time: O(n); Space: O(1)
	 */
	public boolean canJump1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;	// invalid input
		}
		
		int reach = 0;	// the rightmost index that can jump to
		for (int i = 0; i <= reach && reach < nums.length; i++) {	// from left to right
			reach = Math.max(reach, i + nums[i]);	// at each index i, calculate the rightmost index that can be reached
			if (reach >= nums.length - 1) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * DP.
	 * Time: O(n); Space: O(1)
	 */
	public boolean canJump2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;	// invalid input
		}
		
		int steps = 0;
		for (int i = 1; i < nums.length; i++) {
			steps = Math.max(steps, nums[i - 1]) - 1;	// d(i) = the number of steps that can go further at index i
			if (steps < 0) {
				return false;
			}
		}
		
		return steps >= 0;
	}
	
	public static void main(String[] args) {
		JumpGame_E55M_I116M obj = new JumpGame_E55M_I116M();
		System.out.println(obj.canJump1(null));	// false
		System.out.println(obj.canJump2(null));	// false
		System.out.println(obj.canJump1(new int[]{}));	// false
		System.out.println(obj.canJump2(new int[]{}));	// false
		
		int[] a = {2, 2, 1, 5, 4};
		System.out.println(obj.canJump1(a));	// true
		System.out.println(obj.canJump2(a));	// true

		int[] b = {3, 2, 1, 0, 4};
		System.out.println(obj.canJump1(b));	// false
		System.out.println(obj.canJump2(b));	// false
	}
}

/**
 * LeetCode #55
 * LintCode #116
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
 */

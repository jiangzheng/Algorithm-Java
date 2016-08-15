package dp;

public class RangeSumQueryImmutable_E303E {
	/**
	 * 1-d DP.
	 * Time: O(n); Space: O(1)
	 */
	private int[] sumSoFar;
	
	public RangeSumQueryImmutable_E303E(int[] nums) {
		if (nums != null && nums.length > 0) {
			sumSoFar = new int[nums.length + 1];
			for (int i = 1; i <= nums.length; i++) {
				sumSoFar[i] = sumSoFar[i - 1] + nums[i - 1];	// 0, -2, -2, 1, -4, -2, -3
			}
		}
	}
	
	/**
	 * Time: O(1); Space: O(1)
	 */
	public int sumRange(int i, int j) {
		if (sumSoFar == null || i < 0 || j < 0 || i >= sumSoFar.length || j >= sumSoFar.length - 1 || i > j) {
			return Integer.MIN_VALUE; // invalid input
		}
		
		return sumSoFar[j + 1] - sumSoFar[i];
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		RangeSumQueryImmutable_E303E obj = new RangeSumQueryImmutable_E303E(nums);
		System.out.println(obj.sumRange(5, 2));	// -2147483648
		System.out.println(obj.sumRange(-1, 0));	// -2147483648
		System.out.println(obj.sumRange(0, -1));	// -2147483648
		System.out.println(obj.sumRange(6, 7));	// -2147483648
		System.out.println(obj.sumRange(0, 6));	// -2147483648

		System.out.println(obj.sumRange(0, 0));	// -2
		System.out.println(obj.sumRange(0, 2));	// 1
		System.out.println(obj.sumRange(2, 5));	// -1
		System.out.println(obj.sumRange(0, 5));	// -3
	}
}

/**
 * LeetCode #303
 * Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * - You may assume that the array does not change.
 * - There are many calls to sumRange function.
 * Your NumArray object will be instantiated and called as such:
 * NumArray numArray = new NumArray(nums);
 * numArray.sumRange(0, 1);
 * numArray.sumRange(1, 2);
 */

package array;

public class RotateArray_E189E {
	/**
	 * 3 reversals.
	 * rev(rev(A)rev(B)) = BA
	 * Time: O(n); Space: O(1) 
	 */
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) {
			return;	// invalid input
		}
		
		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);	// 4, 3, 2, 1, 5, 6, 7
		reverse(nums, nums.length - k, nums.length - 1);	// 4, 3, 2, 1, 7, 6, 5
		reverse(nums, 0, nums.length - 1);	// 5, 6, 7, 1, 2, 3, 4
	}

	private void reverse(int[] nums, int from, int to) {
		while (from < to) {
			int temp = nums[from];
			nums[from] = nums[to];
			nums[to] = temp;
			from++;
			to--;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		RotateArray_E189E obj = new RotateArray_E189E();
		
		obj.rotate(a, 3);
		for (int x : a) {
			System.out.print(x + ", ");	// 5, 6, 7, 1, 2, 3, 4
		}
	}
}

/**
 * LeetCode #189
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Hint: Could you do it in-place with O(1) extra space?
 */
 

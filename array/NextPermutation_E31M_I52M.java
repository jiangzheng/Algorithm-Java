package array;

public class NextPermutation_E31M_I52M {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;	// invalid input
		}

		// E.g.: 6 8 7 4 3 2 -> 7 2 3 4 6 8 (partition number: 6, swap with 7)
		// find longest descending tail and reverse it, nums[curr - 1] is the partition number
		int curr = nums.length - 1;
		while (curr > 0 && nums[curr - 1] >= nums[curr]) {
			curr--;
		}
		reverse(nums, curr, nums.length - 1);
		
		// swap nums[curr - 1] and the first larger element on its right side
		if (curr > 0) {
			int next = curr;
			curr--;
			while (nums[curr] >= nums[next]) {
				next++;
			}
			swap(nums, curr, next);
		}
	}
	
	private void reverse(int[] num, int start, int end) {
		while (start < end) {
			swap(num, start++, end--);
		}
	}

	private void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	public static void main(String[] args) {
		NextPermutation_E31M_I52M obj = new NextPermutation_E31M_I52M();		
		int[] a = {1, 2, 3};
		int[] b = {3, 2, 1};
		int[] c = {1, 1, 5};
		obj.nextPermutation(a);
		for (int x : a) {
			System.out.print(x + ", ");	// 1, 3, 2, 
		}
		System.out.println();
		obj.nextPermutation(b);
		for (int x : b) {
			System.out.print(x + ", ");	// 1, 2, 3, 
		}
		System.out.println();
		obj.nextPermutation(c);
		for (int x : c)
			System.out.print(x + ", ");	// 1, 5, 1, 
		System.out.println();
	}
}

/**
 * LeetCode #31
 * LintCode #52
 * Implement next permutation, 
 *   which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 *   (i.e., sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 */

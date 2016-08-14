package array;

public class RemoveElement_E27E_I172E {
	/**
	 * Use two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		
		int pointer = 0;	// identify the first val element
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				if (nums[pointer] != nums[i]) {
					nums[pointer] = nums[i];	// replace the val element with the non-val element
				}
				pointer++;
			}
		}
		
		return pointer;
	}
	
	public static void main(String[] args) {
		int[] A = { 1, 1, 3, 2, 1 };
		int[] B = { 0, 4, 4, 0, 0, 2, 4, 4 };
		RemoveElement_E27E_I172E obj = new RemoveElement_E27E_I172E();
		System.out.println(obj.removeElement(A, 1));	// 2
		System.out.println(obj.removeElement(B, 4));	// 4
	}
}

/**
 * LeetCode #27
 * LintCode #172
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

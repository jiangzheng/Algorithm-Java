package array;

public class RemoveDuplicatesFromSortedArrayII_E80M_I101E {
	/**
	 * Key: Skip nums[i] when two same elements have been found.
	 * More than two duplicates exist iff nums[i] == nums[pos] && nums[i] == nums[pos - 1];
	 * Not store nums[i] for the above case, and store nums[i] for other cases: nums[++pos] = nums[i].
	 * Time: O(n); Space: O(1) 
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		
		if (nums.length <= 2) {
			return nums.length;
		}
		
		int pointer = 1;	// point to the second duplicated element
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[pointer] || nums[i] != nums[pointer - 1]) {
				nums[++pointer] = nums[i];	// replace duplicated elements with distinct elements
			}
		}
		
		return pointer + 1;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII_E80M_I101E obj = new RemoveDuplicatesFromSortedArrayII_E80M_I101E();
		int[] a = { 1, 1, 2 };
		int[] b = { 1, 2, 3, 4 };
		int[] c = { 1, 1, 1, 2, 2, 3 };
		System.out.println(obj.removeDuplicates(a));	// 3
		System.out.println(obj.removeDuplicates(b));	// 4
		System.out.println(obj.removeDuplicates(c));	// 5
	}
}

/**
 * LeetCode #80
 * LintCode #101
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 * It doesn't matter what you leave beyond the new length.
 */

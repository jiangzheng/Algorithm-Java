package array;

public class PartitionArray_I31E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;	// invalid input
		}
		
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			while (left <= right && nums[left] < k) {
				left++;
			}
			while (left <= right && nums[right] >= k) {
				right--;
			}
			
			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) {
		PartitionArray_I31E obj = new PartitionArray_I31E();
		System.out.println(obj.partitionArray(null, 2));	// 0
		System.out.println(obj.partitionArray(new int[]{}, 2));	// 0
		
		int[] a = {3, 2, 2, 1};
		System.out.println(obj.partitionArray(a, 2));	// 1
	}
}

/**
 * LintCode #31
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * Notice
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 * If all elements in nums are smaller than k, then return nums.length
 * Example: If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * Can you partition the array in-place and in O(n)?
 */

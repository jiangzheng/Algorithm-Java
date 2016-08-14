package array;

public class PartitionArrayByOddAndEven_I373E {
	/**
	 * Use two pointers, skip and swap.
	 * Time: O(n); Space: O(1)
	 */
	public void partitionArray(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low < high) {
			while (low < high && nums[low] % 2 == 1) {	// find next even number
				low++;
			}
			while (low < high && nums[high] % 2 == 0) {	// find previous odd number
				high--;
			}
			if (low < high) {	// swap the even number and the odd number
				int temp = nums[low];
				nums[low] = nums[high];
				nums[high] = temp;
				low++;
				high--;
			}
		}
	}
	
	public static void main(String[] args) {
		PartitionArrayByOddAndEven_I373E obj = new PartitionArrayByOddAndEven_I373E();
		int[] array = {3, 2, 1, 4};
		obj.partitionArray(array);
		for (int n : array) {
			System.out.print(n + ", ");	// 3, 1, 2, 4, 
		}
	}
}

/**
 * LintCode #373
 * Partition an integers array into odd number first and even number second.
 * Example: Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * Do it in-place.
 */

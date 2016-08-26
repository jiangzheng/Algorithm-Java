package array;

public class Median_I80E {
	/**
	 * Similar to quick sort, but the goal is to find the median.
	 * Time: O(n log n), Worse Case: O(n^2); Space: O(1)
	 */
	public int median(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		return sub(nums, 0, nums.length - 1, (nums.length + 1) / 2);
	}
	
	private int sub(int[] nums, int low, int high, int size) {
        int mid = (low + high) / 2;
        int pivot = nums[mid];
        int i = low - 1, j = high + 1;
        
        for (int k = low; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                swap(nums, i, k);
            } else if (nums[k] > pivot) {
                j--;
                swap(nums, j, k);
                k--;
            }
        }
        
        if (i - low + 1 >= size) {
            return sub(nums, low, i, size);
        } else if (j - low >= size) {
            return nums[j-1];
        } else {
            return sub(nums, j, high, size - (j - low));
        }
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Median_I80E obj = new Median_I80E();
		System.out.println(obj.median(null));	// -2147483648
		System.out.println(obj.median(new int[]{}));	// -2147483648
		
		int[] a = {4, 5, 1, 2, 3};
		int[] b = {7, 9, 4, 5};
		System.out.println(obj.median(a));	// 3
		System.out.println(obj.median(b));	// 5
	}
}

/**
 * LintCode #80
 * Given a unsorted array with integers, find the median of it.
 * A median is the middle number of the array after it is sorted.
 * If there are even numbers in the array, return the N/2-th number after sorted.
 * Example
 * Given [4, 5, 1, 2, 3], return 3.
 * Given [7, 9, 4, 5], return 5.
 */

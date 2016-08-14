package array;

public class MergeSortedArray_E88E_I64E {
	/**
	 * Merge nums2 into nums1, since nums1 has extra space, 
	 *   we can do in-place merge by backward merging from nums1[m + n - 1].
	 * Time: O(m + n); Space: O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int pointer = m + n - 1;	// point to the position to be updated
		m--;	// backward scan from nums1[m - 1]
		n--;	// backward scan from nums2[n - 1]
		while (n >= 0) {	// if n < 0, no need to update remaining elements in nums1
			if (m < 0 || nums1[m] < nums2[n]) {	// if m < 0, keep update remaining elements in nums1 with nums2's remaining elements
				nums1[pointer--] = nums2[n--];
			} else {
				nums1[pointer--] = nums1[m--];
			}
		}
	}
	
	public static void main(String[] args) {
		MergeSortedArray_E88E_I64E obj = new MergeSortedArray_E88E_I64E();
		int[] A = {1, 5, 6, -1, -1};
		int[] B = {2, 3};
		obj.merge(A, 3, B, 2);
		for (int x : A) {
			System.out.print(x + ", ");	// 1, 2, 3, 5, 6, 
		}
	}
}

/**
 * LeetCode #88
 * LintCode #64
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 *   to hold additional elements from nums2. 
 *   The number of elements initialized in nums1 and nums2 are m and n respectively.
 * Example: A = [1, 2, 3, empty, empty], B = [4, 5] After merge, A will be filled as [1, 2, 3, 4, 5]
 */

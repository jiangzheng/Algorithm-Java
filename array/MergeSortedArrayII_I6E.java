package array;

public class MergeSortedArrayII_I6E {
	/**
	 * Similar to MergeSortedArray_E88E_I64E.
	 * Time: O(m + n); Space: O(m + n)
	 */
	public int[] mergeSortedArray(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int pointer = m + n - 1;	// point to the position to be updated
		int[] result = new int[m + n];
		m--;	// backward scan from A[m - 1]
		n--;	// backward scan from B[n - 1]
		
		while (n >= 0 && m >= 0) {
			if (A[m] < B[n]) {
				result[pointer--] = B[n--];
			} else {
				result[pointer--] = A[m--];
			}
		}
		
		while (m >= 0) {
			result[pointer--] = A[m--];
		}
		
		while (n >= 0) {
			result[pointer--] = B[n--];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MergeSortedArrayII_I6E obj = new MergeSortedArrayII_I6E();
		int[] A = {1, 2, 3, 4};
		int[] B = {2, 4, 5, 6};
		int[] result = obj.mergeSortedArray(A, B);
		for (int x : result) {
			System.out.print(x + ", ");	// 1, 2, 2, 3, 4, 4, 5, 6, 
		}
	}
}

/**
 * LintCode #6
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * A=[1,2,3,4] B=[2,4,5,6] return [1,2,2,3,4,4,5,6]
 * How can you optimize your algorithm if one array is very large and the other is very small?
 */

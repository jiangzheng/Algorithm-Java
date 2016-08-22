package array;

public class PermutationSequence_E60M_I388M {
	/**
	 * Time: O(n^2), Space: O(n)
	 */
	public String getPermutation(int n, int k) {
		if (n < 1 || n > 9 || k < 1) {
			return null;	// invalid input
		}
		
		// k = i0 x (n-1)! + i1 x (n-2)! + ... + i{n-1} x 0! => "i0 i1 ... i{n-1}"
		StringBuilder numberSb = new StringBuilder();	// "12..n"
		int[] factorial = new int[n + 1];	// stores 0!, 1!,..., n!
		factorial[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			numberSb.append(i);
			factorial[i] = factorial[i - 1] * i;
		}
		
		k--;	// start from base 0
		
		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 1; i--) {
			int index = k / factorial[i - 1];
			sb.append(numberSb.charAt(index));
			numberSb.deleteCharAt(index);	// deleteCharAt() takes linear time
			k = k % factorial[i - 1];
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		PermutationSequence_E60M_I388M obj = new PermutationSequence_E60M_I388M();
		System.out.println(obj.getPermutation(0,1));	// null
		System.out.println(obj.getPermutation(10,1));	// null
		System.out.println(obj.getPermutation(3,0));	// null
		
		System.out.println(obj.getPermutation(3,1));	// 123
		System.out.println(obj.getPermutation(3,2));	// 132
		System.out.println(obj.getPermutation(3,3));	// 213
		System.out.println(obj.getPermutation(3,4));	// 231
		System.out.println(obj.getPermutation(3,5));	// 312
		System.out.println(obj.getPermutation(3,6));	// 321
	}
}

/**
 * LeetCode #60
 * LintCode #388
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, We get the following sequence (i.e., for n = 3):
 * "123" "132" "213" "231" "312" "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */

/**
 * No need to find out all permutations. We can use the formula:
 * [i_0 i_1 ... i_{n - 1}] is the kth permutation,
 * where k = i_0 * (n - 1)! + i_1 * (n - 2)! + ... + i_{n - 1} * 0!
 * We only need to determine the coefficients i.
 * Example: "123"
 * 4. "231": 4 - 1 = 3 = 1 * 2 + 1 * 1 + 0 * 1
 * 5. "312": 5 - 1 = 4 = 2 * 2 + 0 * 1 + 0 * 1
 * Note: start k from base 0: k--;
 * need to delete the number after adding it to the permutation.
 */

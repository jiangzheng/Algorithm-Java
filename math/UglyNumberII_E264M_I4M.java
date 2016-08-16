package math;

import java.util.ArrayList;

public class UglyNumberII_E264M_I4M {
	/**
	 * Find next ugly number based on previous ones.
	 * Time: O(n); Space: O(n)
	 */
	public int nthUglyNumber(int n) {
		if (n <= 0) {
			return 0;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int[] primeFactors = {2, 3, 5};	// prime factors may be expanded here
		int[] pointers = new int[primeFactors.length];
				
		while(list.size() < n) {
			int[] nexts = new int[primeFactors.length];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < primeFactors.length; i++) {
				nexts[i] = list.get(pointers[i]) * primeFactors[i];
				if (min > nexts[i]) {
					min = nexts[i];
				}
			}
			list.add(min);
			
			for (int i = 0; i < primeFactors.length; i++) {
				if (min == nexts[i]) {
					pointers[i]++;
				}
			}
		}
		
		return list.get(list.size() - 1);
	}
	
	public static void main(String[] args) {
		UglyNumberII_E264M_I4M obj = new UglyNumberII_E264M_I4M();
		for (int i = 0; i <= 10; i++) {
			System.out.print(obj.nthUglyNumber(i) + ", ");	// 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 
		}
	}
}

/**
 * LeetCode #264
 * LintCode #4
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */

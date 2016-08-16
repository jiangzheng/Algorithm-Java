package math;

import java.util.ArrayList;

public class SuperUglyNumber_E313M_I518M {
	/**
	 * Find next ugly number based on previous ones.
	 * Time: O(n); Space: O(n)
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 0) {
			return 0;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int[] pointers = new int[primes.length];
				
		while(list.size() < n) {
			int[] nexts = new int[primes.length];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < primes.length; i++) {
				nexts[i] = list.get(pointers[i]) * primes[i];
				if (min > nexts[i]) {
					min = nexts[i];
				}
			}
			list.add(min);
			
			for (int i = 0; i < primes.length; i++) {
				if (min == nexts[i]) {
					pointers[i]++;
				}
			}
		}
		
		return list.get(list.size() - 1);
	}
	
	public static void main(String[] args) {
		SuperUglyNumber_E313M_I518M obj = new SuperUglyNumber_E313M_I518M();
		int[] primes = {2, 7, 13, 19};
		for (int i = 0; i <= 12; i++) {
			System.out.print(obj.nthSuperUglyNumber(i, primes) + ", ");
			// 0, 1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32, 
		}
	}
}

/**
 * LeetCode #313
 * LintCode #518
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
 *   given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k <= 100, 0 < n <= 106, 0 < primes[i] < 1000.
 */

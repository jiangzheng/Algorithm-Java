package math;

import java.util.Arrays;

public class CountPrimes_E204E {
	/**
	 * Sieve of Eratosthenes.
	 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * Time: O(n * log n * log n); Space: O(n)
	 */
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}
		
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i <= Math.sqrt(n); i++) {	// 2, 3, 4, ..., not greater than sqrt(n)
			if (isPrime[i]) {	// if true
				for (int j = i * i; j < n; j += i) {	// cross out i^2 + k*i (k = 0, 1, 2, ...)
					isPrime[j] = false;		// these j are not prime numbers
				}
			}
		}
		
		int counter = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		CountPrimes_E204E obj = new CountPrimes_E204E();
		System.out.println(obj.countPrimes(100));	// 25
		System.out.println(obj.countPrimes(120));	// 30
	}
}

/**
 * LeetCode #204
 * Count the number of prime numbers less than a non-negative number, n.
 */

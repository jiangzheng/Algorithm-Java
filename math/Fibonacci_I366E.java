package math;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci_I366E {
	/**
	 * Recursion.
	 * Time: O(2^n)
	 */
	public int fibonacci1(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacci1(n - 1) + fibonacci1(n - 2);
		}
	}
	
	/**
	 * Iteration.
	 * Time: O(n)
	 */
	public int fibonacci2(int n) {
		int prev1 = 0, prev2 = 1;
		
		for(int i = 1; i < n; i++) {
			int temp = prev1 + prev2;
			prev1 = prev2;
			prev2 = temp;
		}
		
		return prev1;
	}
	
	/**
	 * Memoized recursion.
	 * https://en.wikipedia.org/wiki/Memoization
	 */
	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	static {
		  fibCache.add(BigInteger.ZERO);
		  fibCache.add(BigInteger.ONE);
	}
		
	public static BigInteger fibonacci3(int n) {
		if (n >= fibCache.size()) {
			fibCache.add(n, fibonacci3(n-1).add(fibonacci3(n-2)));	// if not calculated, calculate and add the nth number
		}
		
		return fibCache.get(n);	// if already calculated, just get the nth number from the fibCache
	}

	public static void main(String[] args) {
		Fibonacci_I366E obj = new Fibonacci_I366E();
		
		System.out.print("Recursion: "); 
		for (int i = 1; i <= 10; i++) {
			System.out.print(obj.fibonacci1(i) + ", ");	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
		}
		
		System.out.print("\nIteration: "); 
		for (int i = 1; i <= 10; i++) {
			System.out.print(obj.fibonacci2(i) + ", ");	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
		}
		
		System.out.print("\nMemoized recursion: "); 
		for (int i = 1; i <= 10; i++) {
			System.out.print(fibonacci3(i - 1) + ", ");	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
		}
	}
}

/**
 * LintCode #366
 * Find the Nth number in Fibonacci sequence. A Fibonacci sequence is defined as follow:
 * - The first two numbers are 0 and 1.
 * - The i th number is the sum of i-1 th number and i-2 th number.
 * The first ten numbers in Fibonacci sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * Given 1, return 0. Given 2, return 1. Given 10, return 34.
 */

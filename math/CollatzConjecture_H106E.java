package math;

import java.util.*;

public class CollatzConjecture_H106E {
	
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner stdin = new Scanner(System.in);
		String[] numbers = stdin.nextLine().split(" "); // get the input numbers
		
		// convert input strings to numbers
		long N = Long.parseLong(numbers[0]);
		long K = Long.parseLong(numbers[1]);
		
		// calculate the result
		for (long i = 0; i < K; i++) {
			if (N % 2 == 0) {
				N /= 2;
			} else {
				N = 3 * N + 1;
			}
		}
		
		// print the result
		System.out.println(N);	// 111 5 => 754
		
		// close the stdin
		stdin.close();
	}
}

/**
 * Hackerrank #106
 * The Collatz conjecture defines a function f(n) = n/2 if n is even or 3n+1 if n is odd.
 * By repeating this function, it is conjectured that all numbers eventually reach 1.
 * Given two integers N and K separated by a space on STDIN, 
 *   apply the function f to the value N a total K times and print to STDOUT the resulting value.
 * For example, on the input: 111 5
 *   the value at each step should go from 111 to 334 to 167 to 502 to 251 to 754, and your program should print: 754
 */

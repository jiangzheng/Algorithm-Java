package math;

import java.util.*;

public class CoinFlipping_H104E {
	
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner stdin = new Scanner(System.in);
		String[] input = stdin.nextLine().split(" ");   // get the input numbers
		
		// convert input strings to numbers
		long M = Long.parseLong(input[0]);  // # of coin flips
		long N = Long.parseLong(input[1]);  // # of heads
	
		if (M <= 0 || N <= 0) {
			System.out.println(0);  // invalid input numbers
		} else {
			// calculate the result per the Combination formula C(M, N) = (M - N + 1)! / N!
			long numerator = 1;
			for (long i = M; i >= M - N + 1; i--) {
				numerator *= i;
			}
			long denominator = 1;
			for (long i = N; i >= 1; i--) {
				denominator *= i;
				System.out.println(i + ": " + denominator);
			}
			long result = (long) (numerator / denominator);
	
			// print the result
			System.out.println(result);
		}
		
		// close the stdin
		stdin.close();
	}
}

/**
 * Hackerrank #104
 * Given two integers M and N separated by spaces on STDIN, 
 *   output to STDOUT the number of disctinct ways to flip exactly N heads on M coin flips.
 * For example, on the input: 3 2
 * Your program should output (since you could have HHT, HTH, or THH): 3
 */

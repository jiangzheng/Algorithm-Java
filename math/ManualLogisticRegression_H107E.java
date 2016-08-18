package math;

import java.util.*;

public class ManualLogisticRegression_H107E {
	
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner stdin = new Scanner(System.in);
		String[] coefStr = stdin.nextLine().split(" "); // get coefficients
		String[] dataStr = stdin.nextLine().split(" "); // get data
		
		// parse coefficients strings to double numbers
		double[] coef = new double[coefStr.length];
		for (int i = 0; i < coefStr.length; i++) {
			coef[i] = Double.parseDouble(coefStr[i]);
		}
	
		// parse data strings to double numbers
		double[] data = new double[dataStr.length];
		for (int i = 0; i < dataStr.length; i++) {
			data[i] = Double.parseDouble(dataStr[i]);
		}
		
		// calculate the model output
		double a = coef[coef.length - 1];
		for (int i = 0; i < data.length; i++) {
			a += coef[i] * data[i];
		}
		double result = 1.0 / (1.0 + Math.exp(0 - a));
		
		// print the model output
		System.out.printf("%.3f", result);
		
		// close the stdin
		stdin.close();
	}
}

/**
 * Hackerrank #107
 * Write a program that reads a set of logistic regression coefficients separated by spaces 
 * (with the last coefficient corresponding to the intercept), a newline, 
 *   and an row of data to be scored using the given model also separated by spaces.
 * Using the logistic function f(x) = 1 / (1 + e^(-x)), 
 *   compute the model's output and print it to STDOUT rounded to exactly 3 decimal places.
 * For example, given the input:
 * 1.5 2 -1 -2.5 3
 * 2 -1 2 0.5
 * your program should print: 0.679
 * and given:
 * 1 1
 * -1
 * your program should print 0.500
 */

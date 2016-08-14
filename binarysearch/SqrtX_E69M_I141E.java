package binarysearch;

public class SqrtX_E69M_I141E {
	/**
	 * Binary Search.
	 * Time: O(log n); Space: O(1)
	 */
	public int mySqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		
		if (x < 2) {
			return x;
		}
		
		int low = 1, high = x;	// low doesn't start from 0 to avoid divided by 0
		
		while (low < high) {
			int middle = (low + high) / 2;	// binary split
			int quotient = x / middle;	// don't compare x with middle * middle, which will overflow
			if (middle > quotient) {	// if x / middle < middle, middle is too big
				high = middle;
			} else if (middle < quotient) {		// if x / middle > middle, middle is too small
				low = middle + 1;
			} else {
				return middle;	// if x / middle = middle, middle is exactly the square root of x
			}
		}
		
		return low - 1;
	}
	
	public static void main(String[] args) {
		SqrtX_E69M_I141E obj = new SqrtX_E69M_I141E();
		System.out.println(obj.mySqrt(-100));	// 0
		System.out.println(obj.mySqrt(100));	// 10
		System.out.println(obj.mySqrt(3));	// 1
		System.out.println(obj.mySqrt(4));	// 2
		System.out.println(obj.mySqrt(5));	// 2
		System.out.println(obj.mySqrt(10));	// 3
	}
}

/**
 * LeetCode #69
 * LintCode #141
 * Implement int sqrt(int x). Compute and return the square root of x.
 */

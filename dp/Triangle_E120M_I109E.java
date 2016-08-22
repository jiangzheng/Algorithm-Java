package dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle_E120M_I109E {
	/**
	 * 2-d DP (bottom-up).
	 * Let d(i, j) be the min path sum from T[i, j] to the triangle bottom. 
	 * d(i, j) = min{d(i + 1, j), d(i + 1, j + 1)} + T[i, j]
	 * Return d(0, 0).
	 * Time: O(n^2); Space: O(n^2) 
	 */
	public int minimumTotal1(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int n = triangle.size();
		int[][] sum = new int[n][n];
		
		for (int r = n - 1; r >= 0; r--) {
			for (int c = 0; c <= r; c++) {
				if (r == n - 1) {
					sum[r][c] = triangle.get(r).get(c);
				} else {
					sum[r][c] = Math.min(sum[r + 1][c], sum[r + 1][c + 1]) + triangle.get(r).get(c);
				}
			}
		}
		
		return sum[0][0];
	}
	
	/**
	 * 1-d DP (Rotation array).
	 * Time: O(n^2); Space: O(n)
	 */
	public int minimumTotal2(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		int n = triangle.size();
		int[] sum = new int[n];
		
		for (int r = n - 1; r >= 0; r--) {
			for (int c = 0; c <= r; c++) {
				if (r == n - 1) {
					sum[c] = triangle.get(r).get(c);
				} else {
					sum[c] = Math.min(sum[c], sum[c + 1]) + triangle.get(r).get(c);
				}
			}
		}
		
		return sum[0];
	}
		
	public static void main(String[] args) {
		Triangle_E120M_I109E obj = new Triangle_E120M_I109E();
		System.out.println(obj.minimumTotal1(null));	// -2147483648
		System.out.println(obj.minimumTotal2(null));	// -2147483648
		System.out.println(obj.minimumTotal1(new ArrayList<List<Integer>>()));	// -2147483648
		System.out.println(obj.minimumTotal2(new ArrayList<List<Integer>>()));	// -2147483648
		
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		listList.add(list);
		list = new ArrayList<Integer>();
		list.add(3); list.add(4);
		listList.add(list);
		list = new ArrayList<Integer>();
		list.add(5); list.add(6); list.add(7);
		listList.add(list);
		list = new ArrayList<Integer>();
		list.add(4); list.add(1); list.add(8); list.add(3);
		listList.add(list);
		
		System.out.println(obj.minimumTotal1(listList));	// 11
		System.out.println(obj.minimumTotal2(listList));	// 11
	}
}

/**
 * LeetCode #120
 * LintCode #109
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note: Bonus point if you are able to do this using only O(n) extra space, 
 *	   where n is the total number of rows in the triangle.
 */

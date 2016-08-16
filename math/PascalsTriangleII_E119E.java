package math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_E119E {
	/**
	 * Store previous row in another list.
	 * Time: O(k); Space: O(k)
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> l = new ArrayList<Integer>();
		List<Integer> p = new ArrayList<Integer>();	// store previous row in another list
		
		for (int i = 0; i <= rowIndex; i++) {
			l = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)	// set [row][col] to 1 if col == 0 or col == row
					l.add(1);
				else					// otherwise [row][col] = [previous row][col-1] + [previous row][col]
					l.add(p.get(j - 1) + p.get(j));
			}
			p = new ArrayList<Integer>(l);
		}
		
		return l;
	}
	
	public static void main(String[] args) {
		PascalsTriangleII_E119E obj = new PascalsTriangleII_E119E();
		System.out.println(obj.getRow(3));	// [1, 3, 3, 1]
	}
}

/**
 * LeetCode #119
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */

package math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_E118E {
	/**
	 * Per definition.
	 * Time: O(k); Space: O(k^2 = 1+2+...+k)
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> l = new ArrayList<Integer>();	// for each row, create a new ArrayList<Integer>
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {	// set [row][col] to 1 if col == 0 or col == row
					l.add(1);
				} else {				// otherwise [row][col] = [row-1][col-1] + [row-1][col]
					l.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
				}
			}
			list.add(l);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		PascalsTriangle_E118E obj = new PascalsTriangle_E118E();
		List<List<Integer>> list = obj.generate(5);
		for (List<Integer> l : list) {
			System.out.println(l);
		}
	}

}

/**
 * LeetCode #118
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

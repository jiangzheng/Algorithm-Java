package dp;

public class ClimbingStairs_E70E_I111E {
	/**
	 * 1-d DP.
	 * d(i) = d(i - 1) + d(i - 2)
	 * Time: O(n); Space: O(1)
	 */
	public int climbStairs(int n) {
		if (n <= 1) {
			return 1;	// LintCode: if n is 0, should return 1;
		}
		
		int di_2 = 1, di_1 = 1, di = 0;
		for (int i = 2; i <= n; i++) {
			di = di_1 + di_2;	// d(i) = d(i - 1) + d(i - 2)
			di_2 = di_1;
			di_1 = di;
		}
		
		return di;
	}
	
	public static void main(String[] args) {
		ClimbingStairs_E70E_I111E obj = new ClimbingStairs_E70E_I111E();
		for (int i = 0; i < 10; i++) {
			System.out.print(obj.climbStairs(i) + ", ");	// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 
		}
	}
}

/**
 * LeetCode #70
 * LintCode #111
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

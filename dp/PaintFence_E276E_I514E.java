package dp;

public class PaintFence_E276E_I514E {
	/**
	 * 1-d DP.
	 * d(n) = (k - 1)(d(n - 1) + d(n - 2))
	 * Time: O(n); Space: O(n)
	 */
	public int numWays(int n, int k) {
		if (n <= 0 || k <= 0) {
			return 0;	// invalid input
		}
		
		if (n == 1) {
			return n * k;	// special case
		}
		
		int[] d = new int[n + 1];
		d[0] = 0;
		d[1] = k;
		d[2] = k * k;
		
		for (int i = 3; i <= n; i++) {
			d[i] = (k - 1) * (d[i - 1] + d[i - 2]);
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		PaintFence_E276E_I514E obj = new PaintFence_E276E_I514E();
		System.out.println(obj.numWays(0, 2));	// 0
		System.out.println(obj.numWays(3, 0));	// 0

		System.out.println(obj.numWays(1, 2));	// 2
		System.out.println(obj.numWays(1, 5));	// 5
		
		System.out.println(obj.numWays(2, 3));	// 9
		System.out.println(obj.numWays(3, 2));	// 6
	}
}

/**
 * LeetCode #276
 * LintCode #514
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * Note: n and k are non-negative integers.
 * Example: Given n=3, k=2 return 6
 *		post 1	post 2	post 3
 * way1	0		0		1 
 * way2	0		1		0
 * way3	0		1		1
 * way4	1		0		0
 * way5	1		0		1
 * way6	1		1		0
 */

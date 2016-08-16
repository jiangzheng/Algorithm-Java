package math;

import java.util.HashMap;
import java.util.Map;

public class MultiplicativeFactorPairs {
	/**
	 * Time: O(sqrt(n)); Space: O(1)
	 */
	public Map<Integer, Integer> findFactorPairs(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (n == 0) {
			map.put(0, 0);
			return map;
		}
		
		int sqrtn = (n > 0) ? (int)Math.sqrt(n) : (int)Math.sqrt(-n);
		for (int i = -sqrtn; i <= sqrtn; i++) {
			if (i != 0 && (n % i) == 0) {
				map.put(i, n / i);
			}
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		MultiplicativeFactorPairs obj = new MultiplicativeFactorPairs();
		System.out.println(obj.findFactorPairs(0));	// {0=0}
		System.out.println(obj.findFactorPairs(1));	// {-1=-1, 1=1}
		System.out.println(obj.findFactorPairs(-1));	// {-1=1, 1=-1}
		System.out.println(obj.findFactorPairs(24));	// {-1=-24, -2=-12, 1=24, -3=-8, 2=12, -4=-6, 3=8, 4=6}
		System.out.println(obj.findFactorPairs(-24));	// {-1=24, -2=12, 1=-24, -3=8, 2=-12, -4=6, 3=-8, 4=-6}
	}
}

/**
 * Find multiplicative factor pairs for a specific integer.
 */

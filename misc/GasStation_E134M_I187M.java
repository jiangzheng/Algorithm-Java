  package misc;

public class GasStation_E134M_I187M {
	/**
	 * Greedy Algorithm.
	 * Time: O(n); Space: O(1)
	*/
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
			return -1;	// invalid input
		}
		
		int prev = 0, total = 0, start = 0;
		
		for (int i = 0; i < gas.length; i++) {
			prev += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (prev < 0) {
				prev = 0;
				start = i + 1;
			}
		}
		
		if (total < 0) {
			return -1;	// can not travel
		} else {
			return start;
		}
	}
	
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {1, 2, 3, 4, 5};
		
		GasStation_E134M_I187M obj = new GasStation_E134M_I187M();
		System.out.println(obj.canCompleteCircuit(null, null));	// -1
		System.out.println(obj.canCompleteCircuit(null, cost));	// -1
		System.out.println(obj.canCompleteCircuit(gas, null));	// -1
		
		System.out.println(obj.canCompleteCircuit(gas, cost));	// 0
	}
}

/**
 * LeetCode #134
 * LintCode #187
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank 
 *   and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note: The solution is guaranteed to be unique.
 */

package math;

public class BulbSwitcher_E319M {
	/**
	 * Math trick.
	 * Time: O(1); Space: O(1)
	 */
	public int bulbSwitch(int n) {
		if (n <= 0) {
			return -1;	// invalid input;
		}
		
		return (int) Math.sqrt(n);
	}
		
	public static void main(String[] args) {
		BulbSwitcher_E319M obj = new BulbSwitcher_E319M();
		for (int i = -1; i <= 10; i++) {
			System.out.print(obj.bulbSwitch(i) + ", ");	// -1, -1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 
		}
	}
}

/**
 * LeetCode #319
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. 
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). 
 * For the ith round, you toggle every i bulb. 
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * Example: Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 */

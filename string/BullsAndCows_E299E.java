package string;

public class BullsAndCows_E299E {
	/**
	 * 2 counter arrays.
	 * Time: O(n); Space: O(1)
	 */
	public String getHint(String secret, String guess) {
		if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0) {
			return "0A0B";	// invalid input
		}
		
		int bulls = 0;
		int cows = 0;
		int[] secretCharsCounter = new int[10];	// 0 ~ 9
		int[] guessCharsCounter = new int[10];	// 0 ~ 9
		
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;	// increase the number of bulls
			} else {
				secretCharsCounter[secret.charAt(i) - '0']++;
				guessCharsCounter[guess.charAt(i) - '0']++;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			cows += Math.min(secretCharsCounter[i], guessCharsCounter[i]);	// calculate the number of cows
		}
		
		return bulls + "A" + cows + "B";
	}
	
	public static void main(String[] args) {
		BullsAndCows_E299E obj = new BullsAndCows_E299E();
		System.out.println(obj.getHint(null, "7810"));	// 0A0B
		System.out.println(obj.getHint("1807", null));	// 0A0B
		System.out.println(obj.getHint("", "7810"));	// 0A0B
		System.out.println(obj.getHint("1807", ""));	// 0A0B
		
		System.out.println(obj.getHint("1807", "7810"));	// 1A3B
		System.out.println(obj.getHint("1123", "0111"));	// 1A1B
	}
}

/**
 * LeetCode #299
 * You are playing the following Bulls and Cows game with your friend: 
 * You write down a number and ask your friend to guess what the number is. 
 * Each time your friend makes a guess, you provide a hint that indicates how many digits in said 
 *   guess match your secret number exactly in both digit and position (called "bulls") 
 *   and how many digits match the secret number but locate in the wrong position (called "cows"). 
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * For example: Secret number:  "1807" Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, 
 *   use A to indicate the bulls and B to indicate the cows. 
 * In the above example, your function should return "1A3B".
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * Secret number:  "1123" Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, 
 *   and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, 
 *   and their lengths are always equal.
 */

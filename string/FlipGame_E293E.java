package string;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_E293E {
	/**
	 * Time: O(n); Space: O(?)
	 */
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		if (s == null || s.length() < 2) {
			return list;	// invalid input
		}
		
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				list.add(s.substring(0, i) + "--" + s.substring(i + 2));
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		FlipGame_E293E obj = new FlipGame_E293E();
		System.out.println(obj.generatePossibleNextMoves(null));	// []
		System.out.println(obj.generatePossibleNextMoves(""));	// []
		System.out.println(obj.generatePossibleNextMoves("+"));	// []
		System.out.println(obj.generatePossibleNextMoves("++"));	// [--]
		System.out.println(obj.generatePossibleNextMoves("+++"));	// [--+, +--]
		System.out.println(obj.generatePossibleNextMoves("++++"));	// [--++, +--+, ++--]
		System.out.println(obj.generatePossibleNextMoves("+-++"));	// [+---]
		System.out.println(obj.generatePossibleNextMoves("+-+-"));	// []
	}
}

/**
 * LeetCode #293
 * You are playing the following Flip Game with your friend: 
 * Given a string that contains only these two characters: + and -, 
 *   you and your friend take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * If there is no valid move, return an empty list [].
 */

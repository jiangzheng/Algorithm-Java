package string;

public class ShortestWordDistance_E243E {
	/**
	 * Time: O(n); Space: O(1)
	 */
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null || word1.equals(word2)) {
			return -1;	// invalid input
		}
		
		int pointer1 = -1, pointer2 = -1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i])) {
				pointer1 = i;
			}
			if (word2.equals(words[i])) {
				pointer2 = i;
			}
			if (pointer1 != -1 && pointer2 != -1) {
				min = Math.min(Math.abs(pointer1 - pointer2), min);
			}
		}
        
		return min;
	}
	
	public static void main(String[] args) {
		ShortestWordDistance_E243E obj = new ShortestWordDistance_E243E();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		System.out.println(obj.shortestDistance(null, "makes", "coding"));	// -1
		System.out.println(obj.shortestDistance(new String[]{}, "makes", "coding"));	// -1
		System.out.println(obj.shortestDistance(words, null, "coding"));	// -1
		System.out.println(obj.shortestDistance(words, "makes", null));	// -1
		System.out.println(obj.shortestDistance(words, "coding", "coding"));	// -1
		
		System.out.println(obj.shortestDistance(words, "coding", "practice"));	// 3
		System.out.println(obj.shortestDistance(words, "makes", "coding"));	// 1
	}
}

/**
 * LeetCode #243
 * Given a list of words and two words word1 and word2, 
 *   return the shortest distance between these two words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

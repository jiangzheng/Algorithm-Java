package hashtable;

public class LongestSubstringWithAtMostKDistinctCharacters_E159M {
	/**
	 * Two pointer + Hash Table.
	 * Time: O(2n); Space: O(1)
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k < 1) {
			return -1;	// invalid input
		}
		
	    int[] count = new int[256];	// ASCII
	    int start = 0, numberOfDistinctCharacters = 0, maxLength = 0;
	    
	    for (int i = 0; i < s.length(); i++) {
	        if (count[s.charAt(i)] == 0) {
	        	numberOfDistinctCharacters++;
	        }
	        count[s.charAt(i)]++;
	        
	        while (numberOfDistinctCharacters > k) {
	            count[s.charAt(start)]--;
	            if (count[s.charAt(start)] == 0) {
	            	numberOfDistinctCharacters--;
	            }
	            start++;
	        }
	        
	        maxLength = Math.max(i - start + 1, maxLength);
	    }
	    
	    return maxLength;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithAtMostKDistinctCharacters_E159M obj = new LongestSubstringWithAtMostKDistinctCharacters_E159M();
		System.out.println(obj.lengthOfLongestSubstringKDistinct(null, 2));	// -1
		System.out.println(obj.lengthOfLongestSubstringKDistinct("", 2));	// -1
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 0));	// -1
		
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 1));	// 1
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 2));	// 3
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 3));	// 4
    }
}

/**
 * LeetCode #159
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”, T is "ece" which its length is 3.
 */

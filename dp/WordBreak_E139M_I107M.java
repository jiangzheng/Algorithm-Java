package dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_E139M_I107M {
	/**
	 * 1-d DP.
	 * Let d(i) = true iff str[0, i - 1] is breakable.
	 * d(i) = d(j) && str[j, i - 1] \in dict, 0 <= j <= i - 1
	 * Return d(n).
	 * Time: O(n^2); Space: O(n)
	 */
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
    		return false;	// invalid input
    	}
    	
    	// d[i]: s[0..i-1] is breakable
        // d(i) = d(j) && s[j, i], j = 0..i-1
        int n = s.length();
        boolean[] d = new boolean[n + 1];
        d[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (d[j] == true && wordDict.contains(s.substring(j, i))) {
                    d[i] = true;
                    break;
                }
            }
        }
        
        return d[s.length()];
    }
    
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		WordBreak_E139M_I107M obj = new WordBreak_E139M_I107M();
		System.out.println(obj.wordBreak(null, null));	// false
		System.out.println(obj.wordBreak(null, dict));	// false
		System.out.println(obj.wordBreak("leetcode", null));	// false
		System.out.println(obj.wordBreak("", new HashSet<String>()));	// false
		System.out.println(obj.wordBreak("", dict));	// false
		System.out.println(obj.wordBreak("leetcode", new HashSet<String>()));	// false
		
		System.out.println(obj.wordBreak("leetcode", dict));	// true
	}
}

/**
 * LeetCode #139
 * LintCode #107
 * Given a string s and a dictionary of words dict, 
 *   determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s = "leetcode", dict = ["leet", "code"]. 
 * Return true because "leetcode" can be segmented as "leet code".
 */

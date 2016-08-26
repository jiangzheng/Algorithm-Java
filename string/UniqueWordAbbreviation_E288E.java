package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation_E288E {
	/**
	 * Time: O(??); Space: O(??)
	 */
	private Set<String> uniqueDictionary;
	private Map<String, String> abbreviationDictionary;
	
	public UniqueWordAbbreviation_E288E(String[] dictionary) {
		uniqueDictionary = new HashSet<String>();
		abbreviationDictionary = new HashMap<String, String>();
		
		for (String word : dictionary) {
			if (!uniqueDictionary.contains(word)) {
				String s = getAbbreviation(word);
				if (!abbreviationDictionary.containsKey(s)) {
					abbreviationDictionary.put(s, word);
				} else {
					abbreviationDictionary.put(s, "");
				}
				uniqueDictionary.add(word);
			}
		}
	}
	
	/**
	 * Time: O(??); Space: O(??)
	 */
	public boolean isUnique(String word) {
		if (word == null || word.length() == 0) {
			return true;	// invalid input
		}
		
		String s = getAbbreviation(word);
		return (!abbreviationDictionary.containsKey(s) || abbreviationDictionary.get(s).equals(word)) 
				? true : false;
	}
	
	private String getAbbreviation(String word) {
		return (word == null || word.length() < 3) ? word 
				: word.charAt(0) + String.valueOf((word.length() - 2)) + word.charAt(word.length() - 1);
	}
	
	public static void main(String[] args) {
		String[] d = {"deer", "door", "cake", "card"};
		UniqueWordAbbreviation_E288E obj = new UniqueWordAbbreviation_E288E(d);
		
		System.out.println(obj.isUnique(null));	// true
		System.out.println(obj.isUnique(""));	// true
		System.out.println(obj.isUnique("cart"));	// true
		System.out.println(obj.isUnique("make"));	// true
		System.out.println(obj.isUnique("dear"));	// false
		System.out.println(obj.isUnique("cane"));	// false
	}
}

/**
 * LeetCode #288
 * An abbreviation of a word follows the form <first letter><number><last letter>. 
 * Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 *      1
 * b) d|o|g                   --> d1g
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * Example: 
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
 * vwa.isUnique("Word");
 * vwa.isUnique("anotherWord");
 */

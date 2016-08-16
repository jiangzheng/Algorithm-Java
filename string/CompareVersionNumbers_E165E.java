package string;

public class CompareVersionNumbers_E165E {
	/**
	 * Time: O(max{na, nb}); Space: O(na + nb) 
	 */
	public int compareVersion(String version1, String version2) {
		if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) {
			return Integer.MIN_VALUE;	// invalid input
		}
		
		// Since the parameter for the delimiter is a regular expression, we can't use "." and "|" as is.
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		for (int i = 0; i < Math.max(v1.length, v2.length); i++) {	// compare each section
			int s1 = 0, s2 = 0;
				try {
					if (i < v1.length) {
						s1 = Integer.parseInt(v1[i]);
					}
					if (i < v2.length) {
						s2 = Integer.parseInt(v2[i]);
					}
				} catch (Exception e) {
					return Integer.MIN_VALUE;	// invalid input
				}
			if (s1 != s2) {
				return (s1 > s2) ? 1 : -1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		CompareVersionNumbers_E165E obj = new CompareVersionNumbers_E165E();
		System.out.println(obj.compareVersion(null, null));	// -2147483648
		System.out.println(obj.compareVersion("", null));	// -2147483648
		System.out.println(obj.compareVersion(null, ""));	// -2147483648
		System.out.println(obj.compareVersion("A", "1"));	// -2147483648
		System.out.println(obj.compareVersion("1", "_"));	// -2147483648
		
		System.out.println(obj.compareVersion("1", "0"));	// 1
		System.out.println(obj.compareVersion("10.999.1.2", "10.999.1"));	// 1
		
		System.out.println(obj.compareVersion("1", "1"));	// 0
		
		System.out.println(obj.compareVersion("1.2.3.4", "1.12.3.4"));	// -1
	}
}

/**
 * LeetCode #165
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 *   it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */

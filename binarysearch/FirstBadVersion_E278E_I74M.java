package binarysearch;

/**
 * LeetCode version.
 */
class VersionControl {
	public boolean isBadVersion(int version) {
		return true;
	}
}

/**
 * LintCode version.
 */
class SVNRepo {
	public static boolean isBadVersion(int version) {
		return true;
	}
}

public class FirstBadVersion_E278E_I74M extends VersionControl {
	/**
	 * LeetCode version.
	 * Binary Search.
	 * Time: O(log n); Space: O(1)
	 */
	public int firstBadVersion(int n) {
		int low = 1, high = n;

		while (low < high) {
			// The following statement causes the Time Exceed Limit error.
			// Alternative: (1) int middle = low + (high - low) / 2;
			// (2) change low, high, and middle to long, casting if needed.
			int middle = (low + high) / 2;
			if (isBadVersion(middle)) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		
		return low;
	}
	
	/**
	 * LintCode version.
	 * Binary Search.
	 * Time: O(log n); Space: O(1)
	 */
	public int findFirstBadVersion(int n) {
		int low = 1, high = n;

		while (low < high) {
			int mid = (low + high) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
	
	public static void main(String[] args) {
	}
}

/**
 * LeetCode #278
 * LintCode #74
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
 *   which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * The isBadVersion API is defined in the parent class VersionControl.
 *   boolean isBadVersion(int version);
 */

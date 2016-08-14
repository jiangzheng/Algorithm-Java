package array;

public class MajorityElement_E169E_I46E {
	/**
	 * Moore's voting algorithm.
	 * "The majority element is the element that appears more than floor(n/2) times".
	 * So the majority element can cancel out all the other elements 
	 *   and the last remaining one is the majority element.
	 * Time: O(n); Space: O(1)
	 */
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;	// Exception
		}
		
		int candidate = nums[0];	// candidate of the majority element
		int counter = 1;	// counter of majority element candidate
		
		for (int i = 1; i < nums.length; i++) {
			if (counter == 0) {	// turn candidate to nums[i], set the counter to 1
				candidate = nums[i];
				counter = 1;
			} else if (nums[i] == candidate) {	// counter !=0 && nums[i] == candidate
				counter++;
			} else {	// counter !=0 && nums[i] != candidate
				counter--;
			}
		}
		
		return candidate;
	}
	
	public static void main(String[] args) {
		MajorityElement_E169E_I46E obj = new MajorityElement_E169E_I46E();
		int[] a = {1, 1, 2, 5, 1, 2};
		int[] b = {1, 2, 2, 2, 2, 2, 1, 1, 5};
		System.out.println(obj.majorityElement(null));	// -1
		System.out.println(obj.majorityElement(new int[] {}));	// -1
		System.out.println(obj.majorityElement(new int[] {1}));	// 1
		System.out.println(obj.majorityElement(a));	// 1
		System.out.println(obj.majorityElement(b));	// 2
	}
}

/**
 * LeetCode #169
 * LintCode #46
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

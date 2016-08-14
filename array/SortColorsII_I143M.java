package array;

public class SortColorsII_I143M {
	/**
	 * Radix sort (two-pass).
	 * Time: O(2n); Space: O(k) 
	 */
	public int[] sortColors1(int[] colors, int k) {
		if (colors == null || colors.length == 0 || k <= 0) {
			return null;	// invalid input
		}
		
		int[] count = new int[k];
		for (int c : colors) {
			count[c - 1]++;
		}
		
		int pointer = 0;
		for (int i = 0; i < k; i++) {
			while (count[i] > 0) {
				colors[pointer++] = i + 1;
				count[i]--;
			}
		}
		
		return colors;
	}
	
	/**
	 * 3 pointers (squeeze & swap) (one-pass).
	 * Time: O(n); Space: O(1)
	 */
	public int[] sortColors2(int[] colors, int k) {
		if (colors == null || colors.length == 0 || k <= 0) {
			return null;	// invalid input
		}
		
		int pointer = 0, left = 0, right = colors.length - 1;
		int min = 1, max = k;
		while (min < max) {
			while (pointer <= right) {
				if (colors[pointer] == min) {
					swap(colors, pointer++, left++);
				} else if (colors[pointer] == max) {
					swap(colors, pointer, right--);
				} else {
					pointer++;
				}
			}
			pointer = left;	// reset pointer's position
			min++;
			max--;
		}
		
		return colors;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		SortColorsII_I143M obj = new SortColorsII_I143M();
		System.out.println(obj.sortColors1(null, 4));	// null
		System.out.println(obj.sortColors2(null, 4));	// null
		System.out.println(obj.sortColors1(new int[]{}, 4));	// null
		System.out.println(obj.sortColors2(new int[]{}, 4));	// null
		
		int[] a = {3, 2, 2, 1, 4};
		System.out.println(obj.sortColors1(a, -1));	// null
		System.out.println(obj.sortColors2(a, -1));	// null
		System.out.println(obj.sortColors1(a, 0));	// null
		System.out.println(obj.sortColors2(a, 0));	// null
		
		int[] result = obj.sortColors1(a, 4);
		for (int x : result) {
			System.out.print(x + ", ");	// 1, 2, 2, 3, 4, 
		}
		System.out.print("\n");
		result = obj.sortColors2(a, 4);
		for (int x : result)
			System.out.print(x + ", ");	// 1, 2, 2, 3, 4, 
	}
}

/**
 * LintCode #143
 * Given an array of n objects with k different colors (numbered from 1 to k), 
 *   sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 * Example: Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * That will cost O(k) extra memory. Can you do it without using extra memory?
 */

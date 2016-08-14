package array;

public class ContainerWithMostWater_E11M_I383M {
	/**
	 * Use two pointers to squeeze from two ends.
	 * Time: O(n); Space: O(1)
	 */
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;	// invalid input
		}
		
		int maxArea = 0;
		int left = 0, right = height.length - 1;	// two pointers
		
		while (left < right) {
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right]) {	// change shorter line, search to longer's direction
				left++;
			} else {
				right--;
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater_E11M_I383M obj = new ContainerWithMostWater_E11M_I383M();
		System.out.println(obj.maxArea(null));	// 0
		System.out.println(obj.maxArea(new int[]{}));	// 0
		
		int[] a = {1, 2, 6, 4, 5, 3};
		System.out.println(obj.maxArea(a));	// 10
	}
}

/**
 * LeetCode #11
 * LintCode #383
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */

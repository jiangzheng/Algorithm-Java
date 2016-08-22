package array;

public class TrappingRainWater_E42H_I363M {
	/**
	 * Two pointers.
	 * Time: O(n); Space: O(1)
	 */
	public int trap(int[] height) {
		if (height == null || height.length < 2) {
			return 0;	// invalid input
		}
		
		int volume = 0;	// volume
		int left = 0, right = height.length - 1;	// 2 pointers
		int mh = 0;	// current highest water level
		
		while (left < right) {
			//System.out.println("[start=" + left + "; end=" + right + ";height[start]=" + height[left] + "; height[end]=" + height[right] + "; mh=" + mh + "; vol=" + volume + "]");
			int min = Math.min(height[left], height[right]);
			if (mh < min) {
				mh = min;
			}
			
			if (height[left] < height[right]) {
				volume += mh - height[left++];
			} else {
				volume += mh - height[right--];
			}
			//System.out.println("[start=" + left + "; end=" + right + ";height[start]=" + height[left] + "; height[end]=" + height[right] + "; min=" + min + "; mh=" + mh + "; vol=" + volume + "]");
		}

		return volume;
	}
	
	public static void main(String[] args) {
		TrappingRainWater_E42H_I363M obj = new TrappingRainWater_E42H_I363M();
		System.out.println(obj.trap(null));	// 0
		System.out.println(obj.trap(new int[]{}));	// 0
		
		int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(obj.trap(a));	// 6
	}
}

/**
 * LeetCode #42
 * LintCode #363
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

package math;

public class RectangleArea_E223E {
	/**
	 * Time: O(1), Space: O(1)
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int sumOfAreas = (C - A) * (D - B) + (G - E) * (H - F);
		
		return (C < E || G < A || D < F || H < B) ? sumOfAreas : 
			sumOfAreas - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
	}
	
	public static void main(String[] args) {
		RectangleArea_E223E obj = new RectangleArea_E223E();
		System.out.println(obj.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));	// 45
	}
}

/**
 * LeetCode #223
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 */

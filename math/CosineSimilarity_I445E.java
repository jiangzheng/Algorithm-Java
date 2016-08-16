package math;

public class CosineSimilarity_I445E {
	/**
	 * Follow the formula.
	 * Time: O(n); Space: O(1)
	 */
	public double cosineSimilarity(int[] A, int[] B) {
		double invalid = 2.0;
		
		if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
			return invalid;	// invalid input
		}
		
		double sumAB = 0, sumAA = 0, sumBB = 0;
		for (int i = 0; i < A.length; i++) {
			sumAB += A[i] * B[i];
			sumAA += A[i] * A[i];
			sumBB += B[i] * B[i];
		}
		
		return (sumAA == 0 || sumBB == 0) ? invalid : (sumAB / (Math.sqrt(sumAA) * Math.sqrt(sumBB)));
	}
	
	public static void main(String[] args) {
		CosineSimilarity_I445E obj = new CosineSimilarity_I445E();
		int[] A = {1, 2, 3};
		int[] B = {2, 3 ,4};
		
		System.out.println(obj.cosineSimilarity(null, null));	// 2.0
		System.out.println(obj.cosineSimilarity(null, B));	// 2.0
		System.out.println(obj.cosineSimilarity(A, null));	// 2.0
		System.out.println(obj.cosineSimilarity(new int[]{}, B));	// 2.0
		System.out.println(obj.cosineSimilarity(A, new int[]{}));	// 2.0
		System.out.println(obj.cosineSimilarity(A, new int[]{2, 3, 4, 5}));	// 2.0
		System.out.println(obj.cosineSimilarity(A, new int[]{0, 0, 0}));	// 2.0
		System.out.println(obj.cosineSimilarity(new int[]{0, 0, 0}, B));	// 2.0
		
		System.out.println(obj.cosineSimilarity(A, B));	// 0.9925833339709303
	}
}

/**
 * LintCode #445
 * Cosine similarity is a measure of similarity between two vectors of an inner product space that 
 *   measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle.
 * Given two vectors A and B with the same size, calculate the cosine similarity.
 * Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).
 * Given A = [1, 2, 3], B = [2, 3 ,4]. Return 0.9926.
 */

class CosineSimilarity {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 2.0;
        }
        double dividend = 0;
        for (int i = 0; i < A.length; i++) {
            dividend += A[i] * B[i];
        }
        double lenA = euclidLength(A);
        double lenB = euclidLength(B);
        if (lenA == 0 || lenB == 0) {
            return 2.0;
        }
        return dividend / (euclidLength(A) * euclidLength(B));
    }

    public double euclidLength(int[] nums) {
        int squareSum = 0;
        for (int i = 0; i < nums.length; i++) {
            squareSum += nums[i] * nums[i];
        }
        return Math.sqrt(squareSum);
    }

    public static void main(String[] args) {
        CosineSimilarity test = new CosineSimilarity();
        int[] a = {1};
        int[] b = {2};
        System.out.println(test.cosineSimilarity(a, b));
    }
}


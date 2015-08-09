public class LongestIncreasingContinuousSubsequence {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int leftMax = 1;
        int rightMax = 1;
        int left = 1;
        int right = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                left++;
                leftMax = Math.max(leftMax, left);
                right = 1;
            } else {
                right++;
                rightMax = Math.max(rightMax, right);
                left = 1;
            }
        }
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        LongestIncreasingContinuousSubsequence test = new LongestIncreasingContinuousSubsequence();
        int[] A = {5, 1, 2, 3, 4};
        System.out.println(test.longestIncreasingContinuousSubsequence(A));
    }
}
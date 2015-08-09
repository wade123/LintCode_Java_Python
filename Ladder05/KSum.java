public class KSum {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        int[][] pre = new int[1 + k][1 + target];
        pre[0][0] = 1;
        int[][] cur = new int[1 + k][1 + target];
        for (int i = 1; i <= A.length; i++) {
            cur = new int[1 + k][1 + target];
            cur[0][0] = 1;
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int t = 1; t <= target; t++) {
                    if (A[i - 1] > t) {
                        cur[j][t] = pre[j][t];
                    } else {
                        cur[j][t] = pre[j][t] + pre[j - 1][t - A[i - 1]];
                    }
                }
            }
            pre = cur;
        }
        return cur[k][target];
    }

    public static void main(String[] args) {
        KSum test = new KSum();
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        System.out.println(test.kSum(A, k, target));
    }
}
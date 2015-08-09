public class BackpackTwo {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        int[] pre = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            cur = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] <= j) {
                    cur[j] = Math.max(pre[j],
                        V[i - 1] + pre[j - A[i - 1]]);
                } else {
                    cur[j] = pre[j];
                }
            }
            pre = cur;
        }
        return cur[m];
    }

    public static void main(String[] args) {
        BackpackTwo test = new BackpackTwo();
        int m = 10;
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        System.out.println(test.backPackII(m, A, V));
    }
}
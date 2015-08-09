public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int[] pre = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            cur = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] <= j) {
                    cur[j] = Math.max(pre[j], 
                        A[i - 1] + pre[j - A[i - 1]]);
                } else {
                    cur[j] = pre[j];
                }
            }
            pre = cur;
        }
        return cur[m];
    }

    public static void main(String[] args) {
        Backpack test = new Backpack();
        int m = 12;
        int[] A = {2, 3, 5, 7};
        System.out.println(test.backPack(m, A));
    }
}

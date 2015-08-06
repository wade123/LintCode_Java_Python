public class DistinctSubsequences {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        } else if (T.length() == 0) {
            return 1;
        }
        int m = S.length();
        int n = T.length();
        int[] pre = new int[1 + n];
        pre[0] = 1;
        int[] cur = new int[1 + n];
        for (int i = 1; i <= m; i++) {
            cur = new int[1 + n];
            cur[0] = 1;
            for (int j = 1; j <= i && j <= n; j++) {
                if (S.charAt(i - 1) != T.charAt(j - 1)) {
                    cur[j] = pre[j];
                } else {
                    cur[j] = pre[j - 1] + pre[j];
                }
            }
            pre = cur;
        }
        return cur[n];
    }

    public static void main(String[] args) {
        DistinctSubsequences test = new DistinctSubsequences();
        String source = "rrabbbitt";
        String target = "rabbit";
        System.out.println(test.numDistinct(source, target));
    }
}
public class LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        if (B.length() > A.length()) {
            return longestCommonSubsequence(B, A);
        }
        int lenA = A.length();
        int lenB = B.length();
        int[] pre = new int[1 + lenB];
        int[] cur = new int[1 + lenB];
        for (int i = 1; i <= lenA; i++) {
            cur = new int[1 + lenB];
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    cur[j] = pre[j - 1] + 1;
                } else {
                    cur[j] = Math.max(cur[j - 1], pre[j]);
                }
            }
            pre = cur;
        }
        return cur[lenB];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence test = new LongestCommonSubsequence();
        String a = "abcd";
        String b = "eacb";
        System.out.println(test.longestCommonSubsequence(a, b));
    }
}
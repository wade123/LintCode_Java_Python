public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        if (B.length() > A.length()) {
            return longestCommonSubstring(B, A);
        }
        int lenA = A.length();
        int lenB = B.length();
        int[] pre = new int[1 + lenB];
        int[] cur = new int[1 + lenB];
        int maxLength = 0;
        for (int i = 1; i <= lenA; i++) {
            cur = new int[1 + lenB];
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    cur[j] = pre[j - 1] + 1;
                    maxLength = Math.max(maxLength, cur[j]);
                } else {
                    cur[j] = 0;
                }
            }
            pre = cur;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestCommonSubstring test = new LongestCommonSubstring();
        String a = "abcd";
        String b = "cbce";
        System.out.println(test.longestCommonSubstring(a, b));
    }
}

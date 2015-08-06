public class InterleavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        } else if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() < s2.length()) {
            return isInterleave(s2, s1, s3);
        }
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[] pre = new boolean[1 + len2];
        boolean[] cur = new boolean[1 + len2];
        pre[0] = true;
        for (int i = 1; i <= len2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                pre[i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= len1; i++) {
            cur = new boolean[1 + len2];
            cur[0] = pre[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                if (cur[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                    || pre[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    cur[j] = true;
                }
            }
            pre = cur;
        }
        return cur[len2];
    }

    public static void main(String[] args) {
        InterleavingString test  = new InterleavingString();
        String s1 = "abc";
        String s2 = "defgh";
        String s3 = "deafbgch";
        System.out.println(test.isInterleave(s1, s2, s3));
    }
}
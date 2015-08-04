public class PalindromePartitioningTwo {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (j - i == 1
                    || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningTwo test = new PalindromePartitioningTwo();
        String s = "aaaabcb";
        System.out.println(test.minCut(s));
    }
}
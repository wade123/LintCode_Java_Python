public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int maxWordLen = 0;
        for (String string : dict) {
            maxWordLen = Math.max(maxWordLen, string.length());
        }
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            int start = Math.max(0, i - maxWordLen);
            for (int j = start; j < i; j ++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
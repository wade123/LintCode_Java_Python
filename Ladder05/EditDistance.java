public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[] pre = new int[length2 + 1];
        int[] cur = new int[length2 + 1];
        for (int i = 0; i <= length2; i++) {
            pre[i] = i;
        }
        for (int i = 1; i <= length1; i++) {
            cur[0] = i;
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = pre[j - 1];
                } else {
                    cur[j] = Math.min(pre[j - 1], Math.min(cur[j - 1], pre[j])) + 1;
                }
            }
            pre = cur.clone();
        }
        return cur[length2];
    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        String word1 = "mart";
        String word2 = "karma";
        System.out.println(test.minDistance(word1, word2));
    }
}

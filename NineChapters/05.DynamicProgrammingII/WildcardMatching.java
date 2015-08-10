public class WildcardMatching {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }
        boolean[] pre = new boolean[1 + s.length()];
        boolean[] cur = new boolean[1 + s.length()];
        pre[0] = true;
        for (int i = 1; i <= p.length(); i++) {
            cur = new boolean[1 + s.length()];
            cur[0] = pre[0] && p.charAt(i - 1) == '*';
            if (p.charAt(i - 1) != '*') {
                for (int j = 1; j <= s.length(); j++) {
                    cur[j] = pre[j - 1] && (p.charAt(i - 1) == '?'
                        || p.charAt(i - 1) == s.charAt(j - 1));
                }
            } else {
                int k = s.length() + 1;
                for (int j = 0; j <= s.length(); j++) {
                    if (pre[j]) {
                        k = j;
                        break;
                    }
                }
                for (; k <= s.length(); k++) {
                    cur[k] = true;
                }
            }
            pre = cur;
        }
        return cur[s.length()];
    }

     public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("abc", "?*"));
     }
}

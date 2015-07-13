public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        else if (target.length() == 0) {
            return 0;
        }
        else if (source.length() == 0 || source.length() < target.length()) {
            return -1;
        }
        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++){
            int temp = i;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(temp + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                    return temp;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        String source = "abcdbcdefg";
        String target = "bcde";
        StrStr test = new StrStr();
        int result = test.strStr(source, target);
        System.out.println(result);
    }
}
public class LengthOfLastWord {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (end == -1) {
                return 0;
            } else {
                return end - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLastWord test = new LengthOfLastWord();
        System.out.println(test.lengthOfLastWord("f   "));
    }
}

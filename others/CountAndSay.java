public class CountAndSay {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        String str = "1";
        while (n > 1) {
            str = countAndSayHelper(str);
            n--;
        }
        return str;
    }

    private String countAndSayHelper(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            char cur = str.charAt(i);
            int count = 0;
            while (i < str.length() && str.charAt(i) == cur) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay(7));
    }
}

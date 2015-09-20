public class AddBinary {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 && j >= 0) {
            int m = a.charAt(i) - '0';
            int n = b.charAt(j) - '0';
            sum = (m + n + carry) % 2;
            carry = (m + n + carry) / 2;
            sb.append(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int m = a.charAt(i) - '0';
            sum = (m + carry) % 2;
            carry = (m + carry) / 2;
            sb.append(sum);
            i--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        String a = "1";
        String b = "111";
        System.out.println(test.addBinary(a, b));
    }
}

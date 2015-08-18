import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 == j
                    || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        partitionHelper(s, 0, isPalindrome, new ArrayList<String>(), result);
        return result;
    }

    private void partitionHelper(String s, int index, boolean[][] isPalindrome,
        List<String> list, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(list));
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[index][i]) {
                list.add(s.substring(index, i + 1));
                partitionHelper(s, i + 1, isPalindrome, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();
        String s = "aabba";
        System.out.println(test.partition(s));
    }
}

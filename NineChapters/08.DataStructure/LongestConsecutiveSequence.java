import java.util.*;

public class LongestConsecutiveSequence {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int number : num) {
            set.add(number);
        }
        int maxLength = 1;
        for (int number : num) {
            if (set.contains(number)) {
                set.remove(number);
                int left = number - 1;
                int right = number + 1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                }
                maxLength = Math.max(maxLength, right - left - 1);
            } else {
                continue;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        int[] num = {3,1,4,1,5,9,2,6,5};
        System.out.println(test.longestConsecutive(num));
    }
}

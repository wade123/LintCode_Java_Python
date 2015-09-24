import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (!map.containsKey(chr) || map.get(chr) == 0) {
                map.put(chr, 1);
                size++;
            } else {
                map.put(chr, map.get(chr) + 1);
            }
            while (size > k) {
                char temp = s.charAt(start);
                if (map.get(temp).equals(1)) {
                    size--;
                }
                map.put(temp, map.get(temp) - 1);
                start++;
            }
            maxLen = Math.max(i - start + 1, maxLen);
            //System.out.println(s.substring(start, i + 1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters test =
        new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringKDistinct(
            "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));
    }
}
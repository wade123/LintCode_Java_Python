import java.util.*;

class LongestWords {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) {
            return result;
        }
        int maxLen = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > maxLen) {
                maxLen = dictionary[i].length();
                result.clear();
                result.add(dictionary[i]);
            } else if (dictionary[i].length() == maxLen) {
                result.add(dictionary[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestWords test = new LongestWords();
        String[] dictionary = {
          "like",
          "love",
          "hate",
          "yes"
        };
        System.out.println(test.longestWords(dictionary));
    }
}
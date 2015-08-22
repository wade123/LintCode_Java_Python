import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        dict.remove(start);
        queue.offer(start);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] wordArray = word.toCharArray();
                    char charAtJ = wordArray[j];
                    for (char chr = 'a'; chr <= 'z'; chr++) {
                        if (chr == charAtJ) {
                            continue;
                        }
                        wordArray[j] = chr;
                        String temp = String.valueOf(wordArray);
                        if (temp.equals(end)) {
                            return length + 1;
                        }
                        if (dict.contains(temp)) {
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(dict);
        System.out.println(test.ladderLength(start, end, dict));
    }
}

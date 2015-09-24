public class UniqueCharacters {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        boolean[] exist = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            if (exist[str.charAt(i)]) {
                return false;
            }
            exist[str.charAt(i)] = true;
        }
        return true;
    }

    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}

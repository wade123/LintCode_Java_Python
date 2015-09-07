public class SortLettersByCase {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                char temp = chars[i];
                chars[i] = chars[start];
                chars[start] = temp;
                start++;
            }
        }
    }
}
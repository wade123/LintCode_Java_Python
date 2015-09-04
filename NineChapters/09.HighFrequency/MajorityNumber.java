public class MajorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int major = 0;
        int count = 0;
        for (int number : nums) {
            if (count == 0) {
                major = number;
                count = 1;
            } else if (number == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
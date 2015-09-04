public class MajorityNumberTwo {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int one = 0;
        int two = 0;
        int countOne = 0;
        int countTwo = 0;
        for (int number : nums) {
            if (countOne == 0) {
                one = number;
                countOne = 1;
            } else if (number == one) {
                countOne++;
            } else if (countTwo == 0) {
                two = number;
                countTwo = 1;
            } else if (number == two) {
                countTwo++;
            } else {
                countOne--;
                countTwo--;
            }
        }
        countOne = 0;
        countTwo = 0;
        for (int number : nums) {
            if (number == one) {
                countOne++;
            } else if (number == two) {
                countTwo++;
            }
        }
        return countOne > countTwo ? one : two;
    }
}
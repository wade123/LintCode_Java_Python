public class SingleNumber {
    /**
     *@param A : an integer array
     *return : a integer 
     */
    public int singleNumber(int[] A) {
        int result = 0;
        for (int element : A) {
            result ^= element;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();
        int[] nums = {1, 2, 1, 3, 3};
        System.out.println(test.singleNumber(nums));
    }
}
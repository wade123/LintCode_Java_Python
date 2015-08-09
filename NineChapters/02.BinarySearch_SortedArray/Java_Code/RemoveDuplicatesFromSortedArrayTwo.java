public class RemoveDuplicatesFromSortedArrayTwo {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int p = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[p]) {
                nums[++p] = nums[i];
                count = 1;
            } else if (count < 2) {
                nums[++p] = nums[i];
                count++;
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayTwo test = new RemoveDuplicatesFromSortedArrayTwo();
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println("new length: " + test.removeDuplicates(nums));
    }
}
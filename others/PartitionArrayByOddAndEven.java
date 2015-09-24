import java.util.Arrays;

public class PartitionArrayByOddAndEven {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
        //System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        PartitionArrayByOddAndEven test = new PartitionArrayByOddAndEven();
        int[] nums = {1,2,3,4,5,6,7};
        test.partitionArray(nums);
    }
}

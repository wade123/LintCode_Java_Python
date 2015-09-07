public class PartitionArray {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                swap(nums, i, start);
                start++;
            }
        }
        return start;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
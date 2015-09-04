import java.util.Arrays;

class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                i++;
                start++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors2(int[] nums) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            } else if (nums[i] == 1) {
                nums[i] = 2;
                nums[one++] = 1;
            }
        }
    }

    public static void main(String[] args) {
        SortColors test = new SortColors();
        int[] nums = {1, 2, 0, 2, 0, 1};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

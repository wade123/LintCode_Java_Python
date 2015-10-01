public class Median {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return quickSelect(nums, 0, length - 1, length / 2 - 1);
        } else {
            return quickSelect(nums, 0, length - 1, length / 2);
        }
    }

    private int quickSelect(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = left + (right - left) / 2;
        pivotIndex = partition(nums, left, right, pivotIndex);
        if (n == pivotIndex + 1) {
            return nums[pivotIndex];
        } else if (n < pivotIndex + 1) {
            return quickSelect(nums, left, pivotIndex - 1, n);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, n);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i <= right - 1; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, right, storeIndex);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
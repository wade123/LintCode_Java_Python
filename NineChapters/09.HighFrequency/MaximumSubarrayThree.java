import java.util.*;

public class MaximumSubarrayThree {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        if (k > nums.size()) {
            return -1;
        }
        int size = nums.size();
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 1; i <= size; i++) {
            int number = nums.get(i - 1);
            for (int j = k; j > 0; j--) {
                local[j] = Math.max(global[j - 1] + number, local[j] + number);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }

    public static void main(String[] args) {
        MaximumSubarrayThree test = new MaximumSubarrayThree();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-1,-2,-3,-100,-1,-50));
        System.out.println(test.maxSubArray(nums, 2));
    }
}


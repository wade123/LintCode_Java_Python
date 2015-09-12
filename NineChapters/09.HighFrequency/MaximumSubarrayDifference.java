import java.util.*;

public class MaximumSubarrayDifference {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        int size = nums.size();
        int[] maxLeft = new int[size];
        int[] minLeft = new int[size];
        int max = nums.get(0);
        int min = nums.get(0);
        maxLeft[0] = max;
        minLeft[0] = min;
        for (int i = 1; i < size; i++) {
            max = Math.max(nums.get(i), nums.get(i) + max);
            maxLeft[i] = Math.max(maxLeft[i - 1], max);
            min = Math.min(nums.get(i), nums.get(i) + min);
            minLeft[i] = Math.min(minLeft[i - 1], min);
        }
        int[] maxRight = new int[size];
        int[] minRight = new int[size];
        max = nums.get(size - 1);
        min = nums.get(size - 1);
        maxRight[size - 1] = max;
        minRight[size - 1] = min;
        for (int i = size - 2; i >= 0; i--) {
            max = Math.max(nums.get(i), nums.get(i) + max);
            maxRight[i] = Math.max(maxRight[i + 1], max);
            min  = Math.min(nums.get(i), nums.get(i) + min);
            minRight[i] = Math.min(minRight[i + 1], min);
        }
        int maxDiff = 0;
        for (int i = 0; i < size - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(maxLeft[i] - minRight[i + 1]),
                Math.abs(minLeft[i] - maxRight[i + 1])));
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        MaximumSubarrayDifference test = new MaximumSubarrayDifference();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, -3, 1));
        System.out.println(test.maxDiffSubArrays(nums));
    }
}
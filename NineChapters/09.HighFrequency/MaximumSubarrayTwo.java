import java.util.*;

public class MaximumSubarrayTwo {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int sum = nums.get(0);
        int[] max = new int[nums.size()];
        max[0] = nums.get(0); 
        for (int i = 1; i < nums.size(); i++) {
            sum = Math.max(nums.get(i), nums.get(i) + sum);
            max[i] = Math.max(max[i - 1], sum);
        }
        int sumRight = nums.get(nums.size() - 1);
        int[] maxRight = new int[nums.size()];
        maxRight[nums.size() - 1] = sumRight;
        for (int i = nums.size() - 2; i >= 0; i--) {
            sumRight = Math.max(nums.get(i), nums.get(i) + sumRight);
            maxRight[i] = Math.max(maxRight[i + 1], sumRight);
        }
        int maxSum = nums.get(0) + nums.get(nums.size() - 1);
        for (int i = 0; i < nums.size() - 1; i++) {
            maxSum = Math.max(maxSum, max[i] + maxRight[i + 1]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarrayTwo test = new MaximumSubarrayTwo();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, -1, 2, -1, 2));
        System.out.println(test.maxTwoSubArrays(nums));
    }
}
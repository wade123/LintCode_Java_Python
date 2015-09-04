import java.util.*;

public class MinimumSubarray {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int min = nums.get(0);
        int sum = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            sum = Math.min(nums.get(i), sum + nums.get(i));
            min = Math.min(min, sum);
        }
        return min;
    }

    public int minSubArray(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        int min = nums.get(0);
        dp[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = Math.min(nums.get(i), nums.get(i) + dp[i - 1]);
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumSubarray test = new MinimumSubarray();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, -1, -2, 1));
        System.out.println(test.minSubArray(nums));
    }
}
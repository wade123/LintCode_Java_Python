public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        int max = nums.get(0);
        dp[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = Math.max(nums.get(i), nums.get(i) + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray(ArrayList<Integer> nums) {
        int sum = nums.get(0);
        int max = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            sum = Math.max(nums.get(i), nums.get(i) + sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}
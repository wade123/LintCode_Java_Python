public class MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < length && start <= end) {
            if (sum < s) {
                sum += nums[end];
                end++;
            } else {
                minLen = Math.min(minLen, end - start);
                sum -= nums[start];
                start++;
            }
        }
        while (start <= end && sum >= s) {
            minLen = Math.min(minLen, end - start);
            sum -= nums[start];
            start++;
        }
        return minLen < Integer.MAX_VALUE ? minLen : -1;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums = {7};
        System.out.println(test.minimumSize(nums, 7));
    }
}
import java.util.*;

public class SubarraySumClosest {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        if (length == 1) {
            result.add(0);
            result.add(0);
            return result;
        }
        int[][] preSum = new int[length + 1][2];
        for (int i = 1; i <= length; i++) {
            preSum[i][0] = preSum[i - 1][0] + nums[i - 1];
            preSum[i][1] = i;
        }
        Arrays.sort(preSum, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           }
        });
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= length; i++) {
            if ((preSum[i][0] - preSum[i - 1][0]) < min) {
                min = preSum[i][0] - preSum[i - 1][0];
                result.clear();
                result.add(Math.min(preSum[i][1], preSum[i - 1][1]));
                result.add(Math.max(preSum[i][1], preSum[i - 1][1]) - 1);
            }
        }
        return result;
    }
}


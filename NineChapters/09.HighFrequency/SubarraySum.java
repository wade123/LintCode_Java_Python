import java.util.*;

public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
// using HashMap, time O(n), space O(n)
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; // should use long type to avoid overflow!!!
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum == 0) {
                result.add(0);
                result.add(i);
                return result;
            }
            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            } else {
                map.put(sum, i);
            }
        }
        return result;
    }
// brute force: time O(n ^ 2), space O(1)
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySum test = new SubarraySum();
        int[] nums = {-3, 1, 2, -3, 4};
        System.out.println(test.subarraySum(nums));
    }
}

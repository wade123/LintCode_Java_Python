import java.util.ArrayList;
import java.util.Arrays;

public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0
            || nums.get(0) < nums.get(nums.size() - 1)) {
            return;
        }
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums.get(mid) < nums.get(end)) {
                end = mid;
            }
            else if (nums.get(mid) > nums.get(end)) {
                start = mid;    
            }
            else {
                end--;
            }
        }
        int pivot = (nums.get(start) < nums.get(end)) ? start : end;
        reverse(nums, 0, pivot - 1);
        reverse(nums, pivot, nums.size() - 1);
        reverse(nums,0, nums.size() - 1);
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RecoverRotatedSortedArray test = new RecoverRotatedSortedArray();
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(
            1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        test.recoverRotatedSortedArray(nums);
    }
}
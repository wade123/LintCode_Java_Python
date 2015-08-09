public class FindMinimumInRotatedSortedArray {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return Integer.MAX_VALUE;
        }
        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] < num[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(num[start], num[end]);
    }
}
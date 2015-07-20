public class FindMinimumInRotetedSortedArrayTwo {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start + 1 < end) {
            if (num[start] < num[end]) {
                return num[start];
            }
            mid = start + (end - start) / 2;
            if (num[mid] > num[start]) {
                start = mid;
            } else if (num[mid] < num[start]) {
                end = mid;
            } else {
                start++;
            }
        }
        return Math.min(num[start], num[end]);
    }
}
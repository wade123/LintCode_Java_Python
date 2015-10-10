public class SearchInABigSortedArray {
    /**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(int[] A, int target) {
        if (A == null || A.length == 0 || A[0] > target) {
            return -1;
        }
        int end = 0;
        while (end < A.length && A[end] < target) {
            end = 2 * end + 1;
        }
        int start = (end - 1) / 2;
        end = Math.min(end, A.length - 1);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        SearchInABigSortedArray test = new SearchInABigSortedArray();
        int[] nums = {1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7};
        int target = 8;
        System.out.println(test.searchBigSortedArray(nums, target));
    }
}

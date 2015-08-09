public class SearchInRotatedSortedArray {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        if (A[start] < A[end] || A.length == 1) {
            return binarySearch(A, start, end, target);
        }
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] < A[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int pivot = (A[start] < A[end]) ? start : end;
        if (target < A[pivot] || target > A[pivot - 1]) {
            return -1;
        } else if (target >= A[0] && target <= A[pivot - 1]) {
            return binarySearch(A, 0, pivot - 1, target);
        } else {
            return binarySearch(A, pivot, A.length - 1, target);
        }
    }

    private int binarySearch(int[] A, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
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
}
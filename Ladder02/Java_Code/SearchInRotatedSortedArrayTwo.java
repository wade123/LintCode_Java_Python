public class SearchInRotatedSortedArrayTwo {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        if (A[start] < A[end] || A.length == 1) {
            return binarySearch(A, start, end, target);
        }
        int mid;
        while (start + 1 < end) {
            if (A[start] < A[end]) {
                break;
            }
            mid = start + (end - start) / 2;
            if (A[mid] < A[start]) {
                end = mid;
            } else if (A[mid] > A[start]) {
                start = mid;
            } else {
                start++;
            }
        }
        int pivot = (A[start] < A[end]) ? start : end;
        if (target < A[pivot] || target > A[pivot - 1]) {
            return false;
        } else if (target >= A[0] && target <= A[pivot - 1]) {
            return binarySearch(A, 0, pivot - 1, target);
        } else {
            return binarySearch(A, pivot, A.length - 1, target);
        }
    }

    private boolean binarySearch(int[] A, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target || A[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
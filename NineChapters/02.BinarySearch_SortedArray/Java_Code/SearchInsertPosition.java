public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2; // int mid = ......;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (target <= A[start]) {
            return start;
        }
        else if (target <= A[end]) {
            return end;
        }
        else {
            return end + 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,7,9,11,13,15,17};
        int target = 4;
        SearchInsertPosition test = new SearchInsertPosition();
        System.out.println(test.searchInsert(A, target));
    } 
}
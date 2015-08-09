import java.util.*;

class MedianOfTwoSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int length = A.length + B.length;
        if (length % 2 == 0) {
            return (findKth(A, B, length / 2) + findKth(A, B, length / 2 + 1)) / 2.0;
        } else {
            return findKth(A, B, (length + 1) / 2);
        }
    }

    private int findKth(int[] A, int[] B, int k) {
        if (A.length > B.length) {
            return findKth(B, A, k);
        }
        if (A.length == 0) {
            return B[k - 1];
        }
        if (k == 1) {
            return Math.min(A[0], B[0]);
        }
        int aMid = Math.min(k / 2, A.length);
        int bMid = k - aMid;
        if (A[aMid - 1] < B[bMid - 1]) {
            return findKth(Arrays.copyOfRange(A, aMid, A.length), B, k - aMid);
        } else {
            return findKth(A, Arrays.copyOfRange(B, bMid, B.length), k - bMid);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        int[] A = {1,2,3};
        int[] B = {4,5};
        System.out.println(test.findMedianSortedArrays(A, B));
    }
}
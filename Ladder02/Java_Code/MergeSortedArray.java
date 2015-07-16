public class mergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int p = m - 1;
        int q = n - 1;
        int r = m + n - 1;
        while (p >= 0 && q >= 0) {
            if (A[p] > B[q]) {
                A[r--] = A[p--];
            }
            else {
                A[r--] = B[q--];
            }
        }
        while (q >= 0) {
            A[r--] = B[q--];
        }
    }
}
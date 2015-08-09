class Solution:
    """
    @param A: sorted integer array A which has m elements,
              but size of A is m+n
    @param B: sorted integer array B which has n elements
    @return: void
    """
    def mergeSortedArray(self, A, m, B, n):
        p = m - 1
        q = n - 1
        r = m + n - 1
        while p >= 0 and q >= 0:
            if A[p] > B[q]:
                A[r] = A[p]
                p -= 1
            else:
                A[r] = B[q]
                q -= 1
            r -= 1
        while q >= 0:
            A[r] = B[q]
            q -= 1
            r -= 1
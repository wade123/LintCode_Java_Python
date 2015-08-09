class Solution:
    """
    @param A: An integer array.
    @param B: An integer array.
    @return: a double whose format is *.5 or *.0
    """
    def findMedianSortedArrays(self, A, B):
        length = len(A) + len(B)
        if length % 2 == 1:
            return self.findKth(A, B, length / 2 + 1)
        else:
            return (self.findKth(A, B, length / 2) +\
                    self.findKth(A, B, length / 2 + 1)) / 2.0

    def findKth(self, A, B, k):
        if len(A) > len(B):
            return self.findKth(B, A, k)
        else:
            if len(A) == 0:
                return B[k - 1]
            elif k == 1:
                return min(A[0], B[0])
            else:
                A_mid = min(k / 2, len(A))
                B_mid = k - A_mid
                if A[A_mid - 1] > B[B_mid - 1]:
                    return self.findKth(A, B[B_mid:], k - B_mid)
                else:
                    return self.findKth(A[A_mid:], B, k - A_mid)
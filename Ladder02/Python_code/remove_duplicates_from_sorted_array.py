class Solution:
    """
    @param A: a list of integers
    @return an integer
    """
    def removeDuplicates(self, A):
        if A is None or len(A) <= 1:
            return len(A)
        size = 0
        for i in xrange(1, len(A)):
            if A[i] != A[size]:
                size += 1
                A[size] = A[i]
        A[size + 1:] = []
        return size + 1
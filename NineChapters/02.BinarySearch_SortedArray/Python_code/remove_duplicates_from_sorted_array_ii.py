class Solution:
    """
    @param A: a list of integers
    @return an integer
    """
    def removeDuplicates(self, A):
        if len(A) <= 2:
            return len(A)
        size = 0
        count = 1
        for i in xrange(1, len(A)):
            if A[i] != A[size]:
                size += 1
                A[size] = A[i]
                count = 1
            elif A[i] == A[size] and count < 2:
                size += 1
                A[size] = A[i]
                count += 1
        A[size + 1:] = []
        return size + 1
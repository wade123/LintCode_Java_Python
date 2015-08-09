class Solution:
    #@param A and B: sorted integer array A and B.
    #@return: A new sorted integer array
    def mergeSortedArray(self, A, B):
        if not A and not B:
            return []
        if not A:
            return B
        if not B:
            return A
        i = j = 0
        result = []
        while i < len(A) and j < len(B):
            if A[i] <= B[j]:
                result.append(A[i])
                i += 1
            else:
                result.append(B[j])
                j += 1
        while i < len(A):
            result.append(A[i])
            i += 1
        while j < len(B):
            result.append(B[j])
            j += 1
        return result
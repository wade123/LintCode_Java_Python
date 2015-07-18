class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be searched
    @return : a list of length 2, [index1, index2]
    """
    def searchRange(self, A, target):
        if not A:
            return [-1, -1]
        
        start = 0
        end = len(A) - 1
        left_bound = 0
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] < target:
                start = mid
            else:
                end = mid
        if A[start] == target:
            left_bound = start
        elif A[end] == target:
            left_bound = end
        else:
            return [-1, -1]
            
        start = 0
        end = len(A) - 1
        right_bound = 0
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] <= target:
                start = mid
            else:
                end = mid
        if A[end] == target:
            right_bound = end
        else:
            right_bound = start
        
        return [left_bound, right_bound]
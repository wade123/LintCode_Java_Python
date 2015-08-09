class Solution:
    """
    @param A : an integer ratated sorted array and duplicates are allowed
    @param target : an integer to be searched
    @return : a boolean
    """
    def search(self, A, target):
        if not A:
            return False
        start = 0
        end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] > A[end]:
                start = mid
            elif A[mid] < A[end]:
                end = mid
            else:
                end -= 1
        pivot = -1
        pivot = start if A[start] < A[end] else end
        if target > A[pivot - 1] or target < A[pivot]:
            return -1
        if target >= A[0]:
            start = 0
            end = pivot
        if target <= A[-1]:
            start = pivot
            end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] < target:
                start = mid
            else:
                end = mid
        if A[start] == target or A[end] == target:
            return True
        else:
            return False
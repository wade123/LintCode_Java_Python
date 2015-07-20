class Solution:
    # @param num: a rotated sorted array
    # @return: the minimum number in the array
    def findMin(self, num):
        if not num:
            return None
        start = 0
        end = len(num) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if num[mid] > num[end]:
                start = mid
            else:
                end = mid
        return min(num[start], num[end])
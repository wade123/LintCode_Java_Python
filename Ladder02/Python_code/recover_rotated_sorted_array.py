class Solution:
    """
    @param nums: The rotated sorted array
    @return: nothing
    """
    def recoverRotatedSortedArray(self, nums):
        if not nums or nums[0] < nums[-1]:
            return
        start = 0
        end = len(nums) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if nums[mid] > nums[end]:
                start = mid
            elif nums[mid] < nums[start]:
                end = mid
            else:
                end -= 1
        pivot = start if nums[start] < nums[end] else end
        self.reverse(nums, pivot, len(nums) - 1)
        self.reverse(nums, 0, pivot - 1)
        self.reverse(nums, 0, len(nums) - 1)

    def reverse(self, A, start, end):
        while start < end:
            A[start], A[end] = A[end], A[start]
            start, end = start + 1, end - 1

def main():
    test = Solution()
    nums = [1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    test.recoverRotatedSortedArray(nums)

if __name__ == '__main__':
    main()
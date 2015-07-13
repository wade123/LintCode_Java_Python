'''Version 1: my recursion'''
class Solution:
    """
    @param nums: A list of Integers.
    @return: A list of permutations.
    """
    def permute(self, nums):
        if not nums:
            return []
        if len(nums) == 1:
            return [[nums[0]]]
        result = []
        for i in xrange(len(nums)):
            for subPermutation in self.permute(nums[:i] + nums[i + 1:]):
                result.append([nums[i]] + subPermutation)
        return result

'''Version 2: JiuZhang recursion style'''
class SolutionTwo:
    def permute(self, nums):
        if not nums:
            return []
        result = []
        self.helper(result, [], nums)
        return result

    def helper(self, result, lis, nums):
        if len(lis) == len(nums):
            result.append(lis[:])
            return
        for i in xrange(len(nums)):
            if nums[i] in lis:
                continue
            lis.append(nums[i])
            self.helper(result, lis, nums)
            lis.pop()

def main():
    test = Solution()
    nums = [3, 2, 1]
    print test.permute(nums)
if __name__ == '__main__':
    main()
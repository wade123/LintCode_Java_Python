'''Version 1: my recursion'''
class Solution:
    """
    @param nums: A list of Integers.
    @return: A list of permutations.
    """
    def permuteUnique(self, nums):
        if not nums:
            return []
        if len(nums) == 1:
            return [[nums[0]]]
        result = []
        added = []
        for i in xrange(len(nums)):
            if nums[i] not in added:
                added.append(nums[i])
                for subPermutation in self.permuteUnique(nums[:i] + nums[i + 1:]):
                    result.append([nums[i]] + subPermutation)
        return result

'''Version 2: JiuZhang recursion style'''
class SolutionTwo:
    def permuteUnique(self, nums):
        if not nums:
            return []
        result = []
        nums.sort()
        visited = [0 for i in xrange(len(nums))]
        self.helper(result, [], nums, visited)
        return result
    
    def helper(self, result, lis, nums, visited):
        if len(lis) == len(nums):
            result.append(lis[:])
            return
        else:
            for i in xrange(len(nums)):
                if visited[i] or (i != 0 and nums[i] == nums[i - 1] and visited[i - 1] == 0):
                    continue
                else:
                    visited[i] = 1
                    lis.append(nums[i])
                    self.helper(result, lis, nums, visited)
                    lis.pop()
                    visited[i] = 0

def main():
    test = Solution()
    nums = [3, 2, 2]
    print test.permuteUnique(nums)
if __name__ == '__main__':
    main()
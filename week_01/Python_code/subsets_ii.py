'''Version 1: my recursion'''
class Solution:
    """
    @param S: A set of numbers.
    @return: A list of lists. All valid subsets.
    """
    def subsetsWithDup(self, S):
        if not S:
            return []
        S.sort()
        result = []
        self.dfs(S, result, [], 0)
        return result

    def dfs(self, S, result, lis, index):
        if index == len(S):
            if lis not in result:
                result.append(lis)
            return
        self.dfs(S, result, lis, index + 1)
        self.dfs(S, result, lis + [S[index]], index + 1)

'''Version 2: JiuZhang recursion style'''
class SolutionTwo:
    def subsetsWithDup(self, S):
        if not S:
            return []
        S.sort()
        result = []
        self.subsets_helper(S, result, [], 0)
        return result

    def subsets_helper(self, S, result, lis, index):
        result.append(lis[:])
        for i in xrange(index, len(S)):
            if i != index and S[i] == S[i - 1]:
                continue
            lis.append(S[i])
            self.subsets_helper(S, result, lis, i + 1)
            lis.pop()

def main():
    test = Solution()
    S = [1,2,2]
    print test.subsetsWithDup(S)

if __name__ == '__main__':
    main()
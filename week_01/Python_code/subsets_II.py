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

if __name__ == '__main__':
    test = Solution()
    S = [2, 2, 1]
    print test.subsetsWithDup(S)
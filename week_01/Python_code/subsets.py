class Solution:
    """
    @param S: The set of numbers.
    @return: A list of lists. See example.
    """
    def subsets(self, S):
        # write your code here
        if not S:
        	return []
        result = []
        S.sort()
        self.helper(S, [], result, 0)
        return result

    def helper(self, S, lis, result, index):
    	if index == len(S):
    		result.append(lis)
    		return
    	self.helper(S, lis, result, index + 1)
    	self.helper(S, lis + [S[index]], result, index + 1)
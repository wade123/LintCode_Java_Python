'''Version 1: my recursion'''
class Solution:
    """
    @param S: The set of numbers.
    @return: A list of lists. See example.
    """
    def subsets(self, S):
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

'''Version 2: JiuZhang recursion style'''
class SolutionTwo:
    def subsets(self, S):
        if not S:
            return []
        S.sort()
        result = []
        self.subsets_helper(S, result, [], 0)
        return result

    def subsets_helper(self, S, result, lis, index):
        result.append(lis[:])
        for i in xrange(index, len(S)):
            lis.append(S[i])
            self.subsets_helper(S, result, lis, i + 1)
            lis.pop()

def main():
    test = Solution()
    S = [1,2,3]
    print test.subsets(S)

if __name__ == '__main__':
    main()
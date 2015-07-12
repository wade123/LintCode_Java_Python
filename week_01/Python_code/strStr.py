class Solution:
    def strStr(self, source, target):
        if target is None or source is None:
            return -1
        elif len(target) == 0:
            return 0
        elif len(source) == 0 or len(target) > len(source):
            return -1
        for i in xrange(len(source) - len(target) + 1):
            temp = i
            for j in xrange(0, len(target)):
                if source[temp + j] != target[j]:
                    break
                if j == len(target) - 1:
                    return temp
        return -1

if __name__ == '__main__':
    test = Solution()
    source = 'abcdabcdefg'
    target = 'bcde'
    print test.strStr(source, target)
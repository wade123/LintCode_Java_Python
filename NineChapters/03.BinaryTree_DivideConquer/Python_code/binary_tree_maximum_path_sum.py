"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    """
    @param root: The root of binary tree.
    @return: An integer
    """
    def maxPathSum(self, root):
        Max = [-sys.maxint]
        self.singleMax(root, Max)
        return Max[0]
    
    def singleMax(self, root, Max):
        if root is None:
            return 0
        left = self.singleMax(root.left, Max)
        right = self.singleMax(root.right, Max)
        singleMaxVal = 0
        singleMaxVal = max(root.val, root.val + left, root.val + right)
        Max[0] = max(Max[0], singleMaxVal, root.val + left + right)
        return singleMaxVal
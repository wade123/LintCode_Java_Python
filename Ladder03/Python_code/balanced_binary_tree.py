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
    @return: True if this Binary tree is Balanced, or false.
    """
    def isBalanced(self, root):
        if root == None:
            return True
        if abs( self.depth(root.left) - self.depth(root.right) ) > 1:
            return False
        else:
            return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def depth(self, root):
        if root == None:
            return 0
        else:
            return 1 + max( self.depth(root.left), self.depth(root.right) ) 
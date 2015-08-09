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
    @return: True if the binary tree is BST, or false
    """  
    def isValidBST(self, root):
        if root is None:
            return True
        else:
            inorder = self.inorderTraversal(root)
            for i in xrange(len(inorder) - 1):
                if inorder[i] >= inorder[i + 1]:
                    return False
            return True
    
    def inorderTraversal(self, root):
        if root is None:
            return []
        result = []
        stack = []
        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                result.append(root.val)
                root = root.right
        return result
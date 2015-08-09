"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
# non-recursive version
class Solution:
    """
    @param root: The root of binary tree.
    @return: Preorder in ArrayList which contains node values.
    """
    def preorderTraversal(self, root):
        if root is None:
            return []
        stack = []
        result = []
        while root or stack:
            if root:
                result.append(root.val)
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                root = root.right
        return result

    def preorderTraversal(self, root):
        if root == None:
            return []
        result = []
        stack = [root]
        while len(stack) != 0:
            node = stack.pop()
            result.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return result

# Divide and conquer
class Solution:
    def preorderTraversal(self, root):
        if not root:
            return []
        left = self.preorderTraversal(root.left)
        right = self.preorderTraversal(root.right)
        return [root.val] + left + right

    def preorderTraversal(self, root):
        return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right) if root else []

# recursive version
class Solution:
    def preorderTraversal(self, root):
        res = []
        if not root:
            return res
        self.dfs(root, res)
        return res

    def dfs(self, node, res):
        res.append(node.val)
        if node.left:
            self.dfs(node.left, res)
        if node.right:
            self.dfs(node.right, res)    
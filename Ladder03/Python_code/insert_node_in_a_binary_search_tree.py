"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
# recursive version
class Solution:
    """
    @param root: The root of the binary search tree.
    @param node: insert this node into the binary search tree.
    @return: The root of the new binary search tree.
    """
    def insertNode(self, root, node):
        if root is None:
            return node
        if node is None:
            return root
        if node.val > root.val:
            root.right = self.insertNode(root.right, node)
        elif node.val < root.val:
            root.left = self.insertNode(root.left, node)
        return root

# non-recursive version
class Solution:
    def insertNode(self, root, node):
        if root is None:
            return node
        if node is None:
            return root
        p = root
        while p:
            if node.val > p.val:
                if p.right is None:
                    p.right = node
                    return root
                else:
                    p = p.right
            else:
                if p.left is None:
                    p.left = node
                    return root
                else:
                    p = p.left
        return root
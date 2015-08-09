/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// recursive version
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null) {
            return root;
        }
        if (root == null) {
            return node;
        }
        if (node.val > root.val) {
            root.right = insertNode(root.right, node);
        } else {
            root.left = insertNode(root.left, node);
        }
        return root;
    }
}

// non-recursive version
public class Solution {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null) {
            return root;
        }
        if (root == null) {
            return node;
        }
        TreeNode p = root;
        while (p != null) {
            if (node.val > p.val) {
                if (p.right == null) {
                    p.right = node;
                    break;
                } else {
                    p = p.right;
                }
            } else {
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }
            }
        }
        return root;
    }
}
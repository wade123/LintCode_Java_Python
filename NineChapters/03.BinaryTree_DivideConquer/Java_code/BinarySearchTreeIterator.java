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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public Solution(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.empty();
    }
    
    //@return: return next node
    public TreeNode next() {
        TreeNode node = stack.pop();
        TreeNode root = node;
        if (root.right != null) {
            stack.push(root.right);
            root = root.right;
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
        }
        return node;
    }
}
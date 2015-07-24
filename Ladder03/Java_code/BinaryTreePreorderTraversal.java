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
// recursive version:
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    private ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        preorderTraversalHelper(root);
        return result;
    }

    private void preorderTraversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelper(root.left);
        preorderTraversalHelper(root.right);
    }
}
// non-recursive version:
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
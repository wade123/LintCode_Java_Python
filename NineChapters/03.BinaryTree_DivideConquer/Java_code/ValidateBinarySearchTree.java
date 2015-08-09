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
// my straight-forward method
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private ArrayList<Integer> result = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inorderTraversal(root);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}
// recursive min && max 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private boolean validBST(TreeNode root, Double min, Double max) {
        if (root == null) {
            return true;
        } else if (root.val > min && root.val < max) {
            Double rootValue = Double.valueOf(root.val);
            return validBST(root.left, min, rootValue) && validBST(root.right, rootValue, max);
        } else {
            return false;
        }
    }
}
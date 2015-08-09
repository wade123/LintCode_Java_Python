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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        singleMaxPathSum(root);
        return max;
    }

    private int singleMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = singleMaxPathSum(root.left);
        int right = singleMaxPathSum(root.right);
        int singleMaxPathSum = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, Math.max(singleMaxPathSum, root.val + left + right));
        return singleMaxPathSum;
    }
}
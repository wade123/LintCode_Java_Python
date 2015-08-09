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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((inorder == null || inorder.length == 0) ||
            (postorder == null || postorder.length == 0)) {
            return null;
        }
        int length = inorder.length;
        return buildTreeHelper(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder,
        int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRootIndex = i;
                break;
            }
        }
        TreeNode left = buildTreeHelper(inorder, postorder, inStart, inRootIndex - 1,
            postStart, postStart + (inRootIndex - inStart) - 1);
        TreeNode right = buildTreeHelper(inorder, postorder, inRootIndex + 1, inEnd,
            postStart + (inRootIndex - inStart), postEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder == null || preorder.length == 0) ||
            (inorder == null || inorder.length == 0)) {
            return null;
        }
        int length = preorder.length;
        return buildTreeHelper(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
        int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex;
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRootIndex = i;
                break;
            }
        }
        TreeNode left = buildTreeHelper(preorder, inorder, preStart + 1,
            preStart + (inRootIndex - inStart), inStart, inRootIndex - 1);
        TreeNode right = buildTreeHelper(preorder, inorder, 
            preStart + (inRootIndex - inStart) + 1, preEnd, inRootIndex + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
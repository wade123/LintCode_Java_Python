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
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        return sortedArrayToBSTHelper(A, 0, A.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = sortedArrayToBSTHelper(array, start, mid - 1);
        root.right = sortedArrayToBSTHelper(array, mid + 1, end);
        return root;
    }
}
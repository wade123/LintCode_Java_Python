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
public class Subtree {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
        public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        } else if (T1 == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(T1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (sameTree(node, T2)) {
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean sameTree(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null || one.val != two.val) {
            return false;
        } else {
            return sameTree(one.left, two.left)
                && sameTree(one.right, two.right);
        }
    }
}
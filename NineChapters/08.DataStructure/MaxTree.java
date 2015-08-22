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
public class MaxTree {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
// O(n) time and space complexity: using a decreasing stack
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int element : A) {
            TreeNode node = new TreeNode(element);
            while (!stack.empty() && element > stack.peek().val) {
                node.left = stack.pop();
            }
            if (!stack.empty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return stack.get(0);
    }
// recursive: O(n * log(n)) if tree is balanced, worst case O(n^2) if the tree is like a LinkedList
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        return maxTreeHelper(A, 0, A.length - 1);
    }

    private TreeNode maxTreeHelper(int[] A, int left, int right) {
        if (length > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = length; i <= right; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        TreeNode leftTree = maxTreeHelper(A, left, index - 1);
        TreeNode rightTree = maxTreeHelper(A, index + 1, right);
        TreeNode root = new TreeNode(max);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}

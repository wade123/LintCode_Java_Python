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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size;
        boolean isEvenLevel = true;
        while (!queue.isEmpty()) {
            int count = 0;
            size = queue.size();
            ArrayList<Integer> values = new ArrayList<Integer>();
            while (count < size) {
                TreeNode node = queue.remove();
                values.add(node.val);
                count++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (isEvenLevel) {
                isEvenLevel = false;
            } else {
                Collections.reverse(values);
                isEvenLevel = true;
            }
            result.add(values);
        }
        return result;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> cur = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        cur.push(root);
        boolean isEvenLevel = true;
        while (!cur.empty()) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            while (!cur.empty()) {
                TreeNode node = cur.pop();
                values.add(node.val);
                if (isEvenLevel) {
                    if (node.left != null) {
                        next.push(node.left);
                    }
                    if (node.right != null) {
                        next.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        next.push(node.right);
                    }
                    if (node.left != null) {
                        next.push(node.left);
                    }
                }
            }
            result.add(values);
            isEvenLevel = !isEvenLevel;
            cur = (Stack) next.clone();
            next.clear();
        }
        return result;
    }
}
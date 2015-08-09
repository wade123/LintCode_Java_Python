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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        result.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            result.append(",");
            if (node.left != null) {
                queue.add(node.left);
                result.append(node.left.val);
            } else {
                result.append("#");
            }
            result.append(",");
            if (node.right != null) {
                queue.add(node.right);
                result.append(node.right.val);
            } else {
                result.append("#");
            }
        }
        for (int i = result.length() - 1; i >= 0; i -= 2) {
            if (result.charAt(i) == '#') {
                result.deleteCharAt(i);
                result.deleteCharAt(i - 1);
            } else {
                break;
            }
        }
        return result.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodeStrings = data.split(",");
        int index = 0;
        int length = nodeStrings.length;
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrings[index]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        index++;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (index < length) {
                String left = nodeStrings[index];
                index++;
                if (!left.equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.add(node.left);
                }
            }
            if (index < length) {
                String right = nodeStrings[index];
                index++;
                if (!right.equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
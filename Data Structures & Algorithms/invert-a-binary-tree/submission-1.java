/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.pop();

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            var tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        return root;

        //return rec(root);
    }

    public TreeNode rec(TreeNode root) {
        if (root == null) {
            return null;
        }

        rec(root.right);
        rec(root.left);

        var tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}

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
    public int maxDepth(TreeNode root) {
        var stack = new Stack<Pair<TreeNode, Integer>>();
        var result = 0;

        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            var current = stack.pop();
            var depth = current.getValue();
            var node = current.getKey();

            if (node != null) {
                result = Math.max(result, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }

        return result;

        //return rec(root);
    }

    public int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(rec(root.right), rec(root.left));
    }
}

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var current = queue.pop();

            if (current.val == subRoot.val) {
                var same = sameTree(current, subRoot);

                if (same) {
                    return true;
                }
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return false;
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        return root.val == subRoot.val && sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}

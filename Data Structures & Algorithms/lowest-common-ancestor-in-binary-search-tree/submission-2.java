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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var current = root;

        while (current != null) {
            if (Math.max(p.val, q.val) < current.val) {
                current = current.left;
            } else if (Math.min(p.val, q.val) > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[] {null};

        findAnc(root, p.val, q.val, result);

        return result[0];
    }

    public void findAnc(TreeNode root, int p, int q, TreeNode[] result) {
        if (root == null || result[0] != null) {
            return;
        }

        if (p < root.val && q < root.val) {
            findAnc(root.left, p, q, result);
        } else if (p > root.val && q > root.val) {
            findAnc(root.right, p, q, result);
        } else {
            result[0] = root;
        }
    }
}

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
        TreeNode[] result = new TreeNode[] {new TreeNode()};

        findAnc(root, p.val, q.val, result);

        return result[0];
    }

    public void findAnc(TreeNode root, int p, int q, TreeNode[] result) {
        if (root == null) {
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

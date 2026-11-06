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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        var queue = new ArrayDeque<Pair<TreeNode, long[]>>();
        queue.add(new Pair<>(root, new long[] {Long.MIN_VALUE, Long.MAX_VALUE}));

        while(!queue.isEmpty()) {
            var pair = queue.pop();
            var node = pair.getKey();
            var min = pair.getValue()[0];
            var max = pair.getValue()[1];

            if (node.val <= min || node.val >= max) {
                return false;
            }

            if (node.left != null) {
                queue.add(new Pair<>(node.left, new long[] {min, (long) node.val}));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, new long[] {(long) node.val, max}));
            }
        }

        return true;
    }

    public boolean isValidBSTrec(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!checkLess(root.left, root.val)) {
            return false;
        }

        if (!checkGreater(root.right, root.val)) {
            return false;
        }

        return isValidBST(root.right) && isValidBST(root.left);
    }

    public boolean checkLess(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        return root.val < val && checkLess(root.left, val) && checkLess(root.right, val);
    }

    public boolean checkGreater(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        return root.val > val && checkGreater(root.left, val) && checkGreater(root.right, val);
    }
}

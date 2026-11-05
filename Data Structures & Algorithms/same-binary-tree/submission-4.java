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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var pstr = serialize(p);
        var qstr = serialize(q);

        return pstr.equals(qstr);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        return toStr(root) + ", left:" + serialize(root.left) + ", right: " + serialize(root.right);
    }

    public String toStr(TreeNode n) {
        if (n == null) {
            return "";
        }

        return n.val + "";
    }

    public boolean isSameTreeIter(TreeNode p, TreeNode q) {
        var stack = new Stack<Pair<TreeNode, TreeNode>>();
        stack.push(new Pair<>(p, q));

        while(!stack.isEmpty()) {
            var nodes = stack.pop();
            var node1 = nodes.getKey();
            var node2 = nodes.getValue();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            stack.push(new Pair<>(node1.left, node2.left));
            stack.push(new Pair<>(node1.right, node2.right));
        }

        return true;
        
        //return rec(p, q);
    }

    public boolean rec(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}

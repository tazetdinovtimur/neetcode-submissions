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
    public int kthSmallest(TreeNode root, int k) {
        var nums = new ArrayList<Integer>();

        collect(root, nums);

        Collections.sort(nums);

        return nums.get(k - 1);
    }

    public void collect(TreeNode root, ArrayList<Integer> nums) {
        if (root == null) {
            return;
        }

        nums.add(root.val);

        collect(root.right, nums);
        collect(root.left, nums);
    }
}

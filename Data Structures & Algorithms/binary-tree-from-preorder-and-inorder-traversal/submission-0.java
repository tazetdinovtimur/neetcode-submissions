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
    // Input: preorder = [1,2,3,4], inorder = [2,1,3,4]

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        var root = new TreeNode(preorder[0]);
        var split = -1;

        for (var i = 0; i < preorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                split = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, split + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, split);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, split + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, split + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}

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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        if (Math.abs(left-right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
}

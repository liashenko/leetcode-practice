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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }
    int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int good = 0;
        if (node.val >= max) {
            good = 1;
            max = node.val;
        }
        return good + dfs(node.left, max) + dfs(node.right, max);
    }
}

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
        //    7
        // 5     10
        //1  12 5
        return dfs(root, -1005, 1005);
    }
    public boolean dfs(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        return root.val > left && root.val < right && 
            dfs(root.left, left, root.val) && 
            dfs(root.right, root.val, right);
    }

}

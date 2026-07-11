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
    public boolean dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return root.val > min && root.val < max && 
            dfs(root.left, min, Math.min(max, root.val)) && 
            dfs(root.right, Math.max(min, root.val), max);
    }

}

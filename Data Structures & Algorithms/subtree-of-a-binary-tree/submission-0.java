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
    public boolean isSubtree(TreeNode p, TreeNode q) {
        if (p == null) {
            return false;
        }
        if (q == null) {
            return true;
        }
        if (isSametree(p, q)) {
            return true;
        }
        return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    public boolean isSametree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val==q.val && isSametree(p.left, q.left) && isSametree(p.right, q.right);

    }
}

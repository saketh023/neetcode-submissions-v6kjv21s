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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(root != null && subroot == null) return false;
        if(root == null) return false;
        if(root.val == subroot.val){
            if(isSame(root.left, subroot.left) && isSame(root.right, subroot.right)) return true;
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s!= null && t!= null && s.val == t.val){
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return false;
    }
}

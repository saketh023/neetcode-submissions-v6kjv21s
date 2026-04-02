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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postTraverse(root, list);
        return list;
    }

    public void postTraverse(TreeNode curr, List<Integer> list){
        if(curr == null){
            return;
        }
        postTraverse(curr.left, list);
        postTraverse(curr.right, list);
        list.add(curr.val);
    }
}
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }

    public void inOrderTraverse(TreeNode curr, List<Integer> list){
        if(curr == null){
            return;
        }
        inOrderTraverse(curr.left, list);
        list.add(curr.val);
        inOrderTraverse(curr.right, list);
    }
}
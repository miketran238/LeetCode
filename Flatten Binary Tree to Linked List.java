/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode head = new TreeNode(0);
    TreeNode curr = head;
    public void flatten(TreeNode root) {
        if ( root ==  null ) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        curr.right = root;
        curr = root;
                curr.left = null;
        curr.right = null;
        flatten(left);

        flatten(right);
    }
}

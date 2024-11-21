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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null; // Base case: the tree is empty or the value isn't found.
        } if (root.val > val) {
            return searchBST(root.left, val); // Search in the left subtree.
        } if (root.val < val) {
            return searchBST(root.right, val); // Search in the right subtree.
        } return root; // Value found.
    }
}

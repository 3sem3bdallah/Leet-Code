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
class Node{
    TreeNode root;
    int depth;
    public Node(TreeNode root,int depth){
        this.root=root;
        this.depth=depth;
    }
}
class Solution {
    private Node rec(TreeNode root){
       if(root==null) return new Node(root,0);
       Node left = rec(root.left);
       Node right= rec(root.right);
       if(left.depth==right.depth){
           return new Node(root,left.depth+1);
       }else if(left.depth > right.depth){
           return new Node(left.root,left.depth+1);
       }
       return new Node(right.root,right.depth+1);    
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       return rec(root).root; 
    }
}
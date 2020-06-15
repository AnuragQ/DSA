package java.trees;

public class BalancedBT {

//  Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 

    private class pair{
        int height;
        boolean isBalanced;
        pair(int height,boolean isBalanced){
            this.height=height;
            this.isBalanced=isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        pair p=myBalanced(root);
        
        return p.isBalanced;
    }
    private pair myBalanced(TreeNode node){
        if(node==null){
            
            return new pair(-1,true);
        }
        pair left=myBalanced(node.left);
        pair right=myBalanced(node.right);
        if(!left.isBalanced || !right.isBalanced){
            return new pair(-1,false);
        }
        if(Math.abs(left.height-right.height)>1){
            return new pair(-1,false);
        }
        return new pair(Math.max(left.height,right.height)+1,true);
        
    }   
    // private int myBalanced2(TreeNode root){
    //     return null;
    // }
}

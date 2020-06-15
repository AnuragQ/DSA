package java.trees;

public class BTFromPostIn {
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
    
     public TreeNode buildTree(int[] postorder, int[] inorder, int post, int poen, int inst, int inen) {
        
        if(post>poen || inst>inen){
            return null;
        }
        TreeNode node=new TreeNode(postorder[poen]);
        int idx=inst,count = 0;
        while(inorder[idx]!=postorder[poen]){
            idx++;
            count++;
        }
        
        node.left = buildTree(postorder,inorder,post,post+count-1,inst,inst+count-1);
        node.right = buildTree(postorder,inorder,post+count,poen-1,inst+count+1,inen);
        
        return node;
        
        
        
    }
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
             return buildTree(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
   
    }
}
package java.trees;


public class R2LPathTargetSum {

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            
                return false;
            
        }
        
        boolean ans=false;
        if(root.left==null && root.right==null){
            if(root.val==sum){
                return true;
            }
            else{
                return false;
            }
        }
        if(root.left!=null){
            ans=ans|| hasPathSum(root.left,sum-root.val) ;
        }
        if(root.right!=null){
              ans=ans|| hasPathSum(root.right,sum-root.val);
        }
        
        
        return ans;
        
    }
}
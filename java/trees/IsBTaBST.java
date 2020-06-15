package java.trees;

public class IsBTaBST {
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
    public boolean isValidBST(TreeNode node , long lo, long hi) {
        if(node==null){
            return true;
        }
        if(node.val<hi && node.val>lo ){
            boolean left=isValidBST(node.left,lo,node.val);
            boolean right=isValidBST(node.right,node.val,hi);
            return left && right;
        }
        return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
package java.trees;

public class MaxSumL2LPath_BT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static class Pair{
        int n2l;
        int l2l;
        Pair(){
            n2l=Integer.MIN_VALUE;
            l2l=Integer.MIN_VALUE;
            
        }
        Pair(int n2l,int l2l){
            this.n2l=n2l;
            this.l2l=l2l;
        }
    }
    
    public static Pair maxPathSumHelper(Node node){
        if(node==null){
            return new Pair();
        }
        if(node.left==null&&node.right==null){
            return new Pair(node.data,Integer.MIN_VALUE);
        }
        Pair myans=new Pair();
        
        Pair left=maxPathSumHelper(node.left);
        Pair right=maxPathSumHelper(node.right);
        if(node.left==null || node.right==null){
            return new Pair(Math.max(left.n2l,right.n2l)+node.data,Integer.MIN_VALUE);
        }
        myans.n2l=Math.max(left.n2l,right.n2l)+node.data;
        myans.l2l=Math.max(Math.max(left.l2l,right.l2l),left.n2l+right.n2l+node.data);
        
        return myans;
        
        
        
    }
    public static int maxPathSum(Node root) {
        // your code here
        return maxPathSumHelper(root).l2l;
    }
}
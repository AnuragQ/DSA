import java.util.ArrayList;
import java.util.List;

//   Definition for a binary tree node.
  
 
class PathSum2 {
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> myans=new ArrayList<>();
        List<Integer> psf=new ArrayList<>();
        pathSum(root,sum,psf,myans);
        return myans;
        
    }
    public void pathSum(TreeNode root, int sum, List<Integer> psf,List<List<Integer>> myans) {
        if(root==null ){
            return;
        }
        
        psf.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==sum){
                ArrayList<Integer> psf_new=new ArrayList<>();
                psf_new.addAll(psf);
                myans.add(psf_new);
            }
        }
        pathSum(root.left,sum-root.val,psf,myans);
        pathSum(root.right,sum-root.val,psf,myans);
        
        psf.remove(psf.size()-1);
    
    }
    
    
    
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     if(root==null){
    //         return new ArrayList<>();
    //     }
    //     List<List<Integer>> myans=new ArrayList<>();
    //     if(root.left==null && root.right==null){
    //         if(root.val==sum){
    //             List<Integer> path=new ArrayList<>();
    //             path.add(root.val);
    //             myans.add(path);
                
    //         }
    //         return myans;
    //     }
    //     List<List<Integer>> lans=pathSum(root.left,sum-root.val);
    //     for(List<Integer> l:lans){
    //         l.add(0,root.val);
    //     }
    //     myans.addAll(lans);
        
    //     List<List<Integer>> rans=pathSum(root.right,sum-root.val);
    //     for(List<Integer> r:rans){
    //         r.add(0,root.val);
    //     }
    //     myans.addAll(rans);
        
        
    //     return myans;
        
    // }
}
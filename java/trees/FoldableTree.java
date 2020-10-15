// https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1
// https://www.geeksforgeeks.org/foldable-binary-trees/
class Tree {
    boolean IsFoldable(Node node) 
	{ 
	    if(node==null){
	        return true;
	    }
		// your code 
		return IsFoldable(node.left,node.right);
		
		
	} 
	boolean IsFoldable(Node node1,Node node2){
	    if(node1==null && node2==null){
	        return true;
	    }
	    if(node1 ==null || node2==null){
	        return false;
	    }
	    return IsFoldable(node1.left,node2.right) && IsFoldable(node1.right,node2.left);
	}
}
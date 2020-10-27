import java.util.ArrayList;
// https://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
class Tree{
    // return the head of the DLL and remove those node from the tree as well.
public Node convertToDLL(Node root)
{
    ArrayList<Node> arr=new ArrayList<>();
    buildArrayList(root,arr);
    // Code here
    for(int i=0;i<arr.size()-1;i++){
        // System.out.println(arr.get(i).data);
        arr.get(i).right=arr.get(i+1);
        arr.get(i+1).left=arr.get(i);
    }
    return arr.get(0);
}
public boolean buildArrayList(Node root,ArrayList<Node> arr){
    if(root==null){
        return false;
    }
    if(root.left==null && root.right==null){
        // System.out.println("here");
        arr.add(root);
        return true;
    }
    boolean ans=false;
    if(root.left!=null){
        ans=buildArrayList(root.left,arr);
        if(ans){
            root.left=null;
        }
    }
    if(root.right!=null){
        
        ans=buildArrayList(root.right,arr);
        if(ans){
            root.right=null;
        }
    }
    return false;
}

}


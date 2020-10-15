
class PopulateInorderSuccessor
{
    class Node
{
    int data;
    Node left,right,next;
    Node(int d) {data = d; left =right= next= null; }
}

    static Node next=null;
    public static void populateNext(Node root)
    {   next=null;
        helper(root);
        next=null;

    }
    public static void helper(Node root)
    {
        if(root==null){
            return;
        }
        //Add your code here.
        helper(root.right);
        root.next=next;
        next=root;
        helper(root.left);
        
    }
    
    
}
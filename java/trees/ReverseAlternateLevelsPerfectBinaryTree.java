// https://practice.geeksforgeeks.org/problems/reverse-alternate-levels-of-a-perfect-binary-tree/1
// https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
public class ReverseAlternateLevelsPerfectBinaryTree
{
	static void reverseAlternate( Node root)  
    {  
        if(root==null){
            return ;
        }
        reverseAlternate(root.left,root.right,true);
       // code here.
    }  
    static void reverseAlternate(Node leftRoot,Node rightRoot,boolean flag){
        if(leftRoot==null || rightRoot==null){
            return;
        }
        if(flag){
            int temp=leftRoot.data;
            leftRoot.data=rightRoot.data;
            rightRoot.data=temp;
        }
        reverseAlternate(leftRoot.left,rightRoot.right,!flag);
        reverseAlternate(leftRoot.right,rightRoot.left,!flag);
        
    }
}




// https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
// https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
class Tree
{
    
    // Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }

    public static void connect(Node node)
        {
            // code here.
            if(node==null){
                return;
            }
            if(node.left!=null){
                if(node.right!=null){
                    node.left.nextRight=node.right;
                }else if(node.nextRight!=null ){
 
                    if(node.nextRight.left!=null){
                        node.left.nextRight=node.nextRight.left;
                    }else if(node.nextRight.right!=null){
                        node.left.nextRight=node.nextRight.right;
                    }
                }
                
            }
            if(node.right!=null){
                if(node.nextRight!=null ){
                    if(node.nextRight.left!=null){
                        node.right.nextRight=node.nextRight.left;
                    }else if(node.nextRight.right!=null){
                        node.right.nextRight=node.nextRight.right;
                    }
                }
            }
            connect(node.left);
            connect(node.right);
            
            
            
        }
}
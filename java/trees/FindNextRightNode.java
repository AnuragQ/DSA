import java.util.ArrayDeque;

class FindNextRightNode {
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data=data;
        }
    }



    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(2);
        root.right=new Node(6);
        root.left.left=new Node(8);
        root.left.right=new Node(4);
        root.right.right=new Node(5);
        int val=2;
        Node nextNode=findNextRight(root,val);
    }

    private static Node findNextRight(FindNextRightNode.Node root, int val) {
        
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(root);
        boolean found=false;
        while(!q.isEmpty()){
            Node rem=
        }

        return null;

    }
}
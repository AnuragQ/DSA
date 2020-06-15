package java.trees;

import java.util.TreeMap;

public class LeftView_BT {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // function should print the LeftView of the binary tree
    static void LeftView(Node node, int level, TreeMap<Integer,Integer> hm){
        if(node==null){
            return;
        }
        if(!hm.containsKey(level) ){
            
            hm.put(level,node.data);
        }
  
        LeftView( node.left ,level+1, hm);
        LeftView( node.right,  level+1,  hm);

        
        
    }
    // Method that prints the bottom view.
    public void leftView(Node root)
    {
         TreeMap<Integer,Integer> hm=new TreeMap<Integer,Integer>();
            LeftView(root,0,hm);
            for(int i:hm.values()){
                System.out.print(i+" ");
            }
    // Code here
    }
}
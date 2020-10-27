package trees;

import java.util.TreeMap;

public class RightView_BT {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    static void rightView(Node node,int level, TreeMap<Integer,Integer> hm){
        if(node==null){
            return;
        }
        hm.put(level,node.data);  
        rightView( node.left,  level+1, hm);
        rightView( node.right,  level+1,  hm);

        
        
    }
    public void rightView(Node root)
    {
         TreeMap<Integer,Integer> hm=new TreeMap<Integer,Integer>();
            rightView(root,0,hm);
            for(Integer i:hm.values()){
                System.out.print(i+" ");
            }
    }
   }
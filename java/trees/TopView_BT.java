//GFG - https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
package trees;

import java.util.TreeMap;

public class TopView_BT {
    class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

    static class pair{
        int data;
        int level;
        pair(int data,int level){
            this.data=data;
            this.level=level;
        }
    }
    // function should print the topView of the binary tree
    static void topView(Node node, int dist,int level, TreeMap<Integer,pair> hm){
        if(node==null){
            return;
        }
        if(!hm.containsKey(dist) ){
            
            hm.put(dist,new pair(node.data,level));
        }else if (hm.get(dist).level>level){
            hm.put(dist,new pair(node.data,level));
            // hm.get(dist).data=node.data;
            // hm.get(dist).level=node.level;
        }
            
        topView( node.left,  dist-1,level+1, hm);
        topView( node.right,  dist+1,level+1,  hm);

        
        
    }
    static void topView(Node root)
    {
        // add your code
            TreeMap<Integer,pair> hm=new TreeMap<Integer,pair>();
            topView(root,0,0,hm);
            for(pair i:hm.values()){
                System.out.print(i.data+" ");
            }
    }

}
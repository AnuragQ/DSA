// NEW space optimized approach read in future -https://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/

package trees;

import java.util.TreeMap;

public class VerticalSum_BT {
    class Node{
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
        }
        static void verticalSum(Node node, int dist, TreeMap<Integer, Integer> hm) {
            if (node == null) {
                return;
            }
            if (!hm.containsKey(dist)) {
    
                hm.put(dist, node.data);
            } else  {
                hm.put(dist, hm.get(dist)+node.data);
                // hm.get(dist).data=node.data;
                // hm.get(dist).level=node.level;
            }
    
            verticalSum(node.left, dist - 1, hm);
            verticalSum(node.right, dist + 1, hm);
    
        }
    
        // Method that prints the bottom view.
        public void verticalSum(Node root) {
            TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();
            verticalSum(root, 0,  hm);
            for (int i : hm.values()) {
                System.out.print(i + " ");
            }
            // Code here
        }
         
}
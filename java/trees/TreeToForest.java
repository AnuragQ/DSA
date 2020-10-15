package trees;


public class TreeToForest {
    public static class Node {
        Node left;
        Node mid;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

   private static class  Pair {
        int nodeCount;
        int removeCount;
    
        Pair( int nodeCount,  int removeCount) {
            this.nodeCount = nodeCount;
            this.removeCount = removeCount;
        }
    }
    public static Node constructTree(int[][] arr, int n){
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (nodes[arr[i][0]].left == null) {
                nodes[arr[i][0]].left = nodes[arr[i][1]];
                // System.out.println("left");
            } else if (nodes[arr[i][0]].mid == null) {
                nodes[arr[i][0]].mid = nodes[arr[i][1]];
                // System.out.println("mid");

            }
            else if (nodes[arr[i][0]].right == null) {
                nodes[arr[i][0]].right = nodes[arr[i][1]];
                // System.out.println("right");

            }
        }
                
        return nodes[1];

    }

    
    public static void main(String[] args) {
        int n = 10;
        int[][] arr = { { 1, 3 }, { 1, 6 }, { 1, 2 }, { 3, 4 }, { 6, 8 }, { 2, 7 }, { 2, 5 }, { 4, 9 }, { 4, 10 } };
        Node root = constructTree(arr,n);
         Pair ans = getMaxRem(root);
        System.out.println(ans.removeCount);
    }

    private static Pair getMaxRem( Node node) {
        if (node == null) {
            return  new Pair(0, 0);
        }

        Pair lans=getMaxRem(node.left);
        Pair mans=getMaxRem(node.mid);
        Pair rans=getMaxRem(node.right);
        Pair myPair=new Pair(0,0);
        myPair.nodeCount=lans.nodeCount+rans.nodeCount+mans.nodeCount+1;
        if(lans.nodeCount>0 && lans.nodeCount%2==0){
            myPair.removeCount+=1;
        }
        if(rans.nodeCount>0 && rans.nodeCount%2==0){
            myPair.removeCount+=1;
        }
        if(mans.nodeCount>0 && mans.nodeCount%2==0){
            myPair.removeCount+=1;
        }
        myPair.removeCount+=lans.removeCount+rans.removeCount+mans.removeCount;
        return myPair;
    }

}

// DFS solution
// import java.util.*;
// public class Main {

//    private static class  Pair {
//         int nodeCount;
//         int removeCount;
    
//         Pair( int nodeCount,  int removeCount) {
//             this.nodeCount = nodeCount;
//             this.removeCount = removeCount;
//         }
//     }


    
//     public static void main(String[] args) {
//         int n = 10;
//         int[][] arr = { { 1, 3 }, { 1, 6 }, { 1, 2 }, 
//         { 3, 4 }, { 6, 8 }, { 2, 7 }, { 2, 5 }, 
//         { 4, 9 }, { 4, 10 } };
        
//         ArrayList<Integer>[] tree=new ArrayList[n+1];
        
//         for(int i=1;i<=n;i++){
//             tree[i]=new ArrayList<>();
//         }
//         for(int i=0;i<arr.length;i++){
//             tree[arr[i][0]].add(arr[i][1]);
//         }
        

//          Pair ans = getMaxRem(tree,1);
//         System.out.println(ans.removeCount);
//     }
    
//     private static Pair getMaxRem(ArrayList<Integer>[] tree,int i) {
        
//         Pair myPair=new Pair(0,0);

//         for(int nbr:tree[i]){
//             Pair ans=getMaxRem(tree,nbr);
//             if(ans.nodeCount>0 && ans.nodeCount%2==0){
//                 myPair.removeCount++;
//             }
//             myPair.removeCount+=ans.removeCount;
//             myPair.nodeCount+=ans.nodeCount;
//         }
//         myPair.nodeCount+=1;
//         return myPair;
//     }

// }

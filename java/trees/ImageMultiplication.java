/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class ImageMultiplication {
    static class Node{
        Node left,right;
        int data;
        Node(){
            
        }
        Node(int data){
            this.data=data;
        }
    }
    static Node constructor(String[] arr){
        HashMap<Integer,Node> nodes=new HashMap<>();
        Node root=null;
        for(int i=0;i<arr.length;i=i+3){
            // System.out.println(i);
            
            int val1=Integer.parseInt(arr[i].replaceAll("[^0-9]",""));
            int val2=Integer.parseInt(arr[i+1].replaceAll("[^0-9]",""));
            
            if(!nodes.containsKey(val1)){
                nodes.put(val1,new Node(val1));   
            }
            if(!nodes.containsKey(val2)){
                nodes.put(val2,new Node(val2));   
            }
            
            Node node1=nodes.get(val1);
            Node node2=nodes.get(val2);
            if(root==null){
                root=node1;
            }
            if(arr[i+2].equals("R")){
                node1.right=node2;
            }else{
                node1.left=node2;
            }
        }
        // System.out.println(nodes.get(4).right.data);
        return root;
    }
    
    public static long product(Node node1,Node node2){
        if(node1==null || node2==null){
            return 0;
        }
        if(node1==null && node2==null){
            return 0;
        }
        long sum=product(node1.left,node2.right);
        sum=(sum+product(node1.right,node2.left))%1000000007;
        sum=(sum+(node1.data*node2.data)%1000000007)%1000000007;
        // System.out.println("here"+ sum);
        return sum;
        
    }
	public static void main (String[] args)throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine().replaceAll("[^0-9]",""));
		    String[] arr=br.readLine().split("\\s+");
		    Node root=constructor(arr);
		    if(root==null){
		        System.out.println(0);
		        continue;
		    }
		    long ans=(product(root.left,root.right)+((long) root.data*root.data)%1000000007)%1000000007;
		    System.out.println(ans);
		}
		
	}
}







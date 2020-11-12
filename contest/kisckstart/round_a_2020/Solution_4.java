
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution_4 {
    

    /* package whatever //do not write package name here */
    
    
    public static int[] one_d(BufferedReader br) throws IOException{
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }   

    static class Node{
        Node[] children;
        int count;
        Node(Node[] children,int count){
            this.children=children;
            this.count=count;
        }
    }
    static void addword(Node root, String str){
        if(str.length()==0){
            root.count++;
            return;
        }
        char ch=str.charAt(0);
        if(root.children[ch-'A']==null){
            root.children[ch-'A']=new Node(new Node[26],0);
        }
        addword(root.children[ch-'A'], str.substring(1));
    }
    static class P{
        int ans;
        int count;
        public P(int ans,int count){
            this.ans=ans;
            this.count=count;
        }
    }
    public static String solution(BufferedReader br) throws IOException{
        int[] params=one_d(br);
        int n=params[0];
        int k=params[1];
        Node root=new Node(new Node[26],0);
        for(int i=0;i<n;i++){
            String str=br.readLine();
            addword(root, str);
        }
        P ans=getScore(root,0,k);
        
        return ""+ans.ans;
    }

    private static Solution_4.P getScore(Solution_4.Node root, int height, int k) {
        if(root==null){
            return new P(0,0);
        }
        P myans=new P(0,0);
        for(int i=0;i<26;i++){
            P childAns=getScore(root.children[i], height+1,k);
            myans.ans+=childAns.ans;           
            myans.count+=childAns.count;
            
        }
        myans.count+=root.count;
        while(myans.count>=k){
            
            myans.ans+=height;
            myans.count-=k;
        }
        return myans;
    }

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            count++;            
            String ans=solution(br);
            System.out.println("Case #"+count+": "+ans);

        }
        

        br.close();

    }
}

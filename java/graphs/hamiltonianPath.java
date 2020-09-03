import java.io.*;
import java.util.*;

public class hamiltonianPath {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
        hamiltonian(graph,src,""+src,new boolean[vtces]);
      // write all your codes here
      
      
      
   }
   public static void hamiltonian(ArrayList<Edge>[] graph,int vtx,String psf,boolean[] visited){
       visited[vtx]=true;
       boolean ans=true;
       for(boolean x:visited){
           ans=ans&&x;
       }
       
       
       char ch='.';
       for(Edge e:graph[vtx]){
           if(!visited[e.nbr]){
               hamiltonian(graph,e.nbr,psf+e.nbr,visited);
           }
           if(e.nbr==0){
               ch='*';
           }
       }
       
       visited[vtx]=false;
       
       if(ans){
           System.out.println(psf+ch);
       }
       
   }


}








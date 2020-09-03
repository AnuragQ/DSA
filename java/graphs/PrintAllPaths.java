import java.io.*;
import java.util.*;

public class PrintAllPaths {
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
    //   ArrayList<Edge>[] graph = new ArrayList[vtces];
          ArrayList<Integer>[] graph = new ArrayList[vtces];

      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
        //  graph[v1].add(new Edge(v1, v2, wt));
        //  graph[v2].add(new Edge(v2, v1, wt));
        graph[v1].add(v2);
        graph[v2].add(v1);
        
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());
       boolean[] visited=new boolean[vtces];
    //   System.out.println( 
    visited[src]=true;
    printPathDFS(graph,src,dest,visited,"");
    // System.out.println( printPathDFS(graph,src,dest));
    

      // write all your codes here
   }
   
   public static void printPathDFS(ArrayList<Integer>[] graph,int src,int dest,boolean[] visited,String psf){
       
       if(src==dest){
           System.out.println(psf+dest);
           return;
       }
       
       for(int i=0; i <graph[src].size();i++){
            if(!visited[graph[src].get(i)]){
                 visited[graph[src].get(i)] =true;
                 printPathDFS(graph,graph[src].get(i),dest,visited,psf+src);
                 visited[graph[src].get(i)] =false;
            }
           
           
       }
       
       
   }


}


































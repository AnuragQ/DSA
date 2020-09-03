import java.io.*;
import java.util.*;

public class HasPath {
//   static class Edge {
//       int src;
//       int nbr;
//       int wt;

//       Edge(int src, int nbr, int wt){
//          this.src = src;
//          this.nbr = nbr;
//          this.wt = wt;
//       }
//   }
@SuppressWarnings({
        "unchecked",
        "deprecation"
    })
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
       
    //   System.out.println( hasPathDFS(graph,src,dest,visited));
    System.out.println( hasPathBFS(graph,src,dest));
    
      
       }
        public static boolean hasPathBFS(ArrayList<Integer>[] graph,int src,int dest){
        
         boolean[] visited=new boolean[graph.length];
      // write your code here
         visited[src]=true;
        
        // if(src==dest){
        //     return true;
        // }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        
        q.add(src);
        
        boolean ans=false;
        
        while(!q.isEmpty()){
            int vt=q.remove();
            if(vt==dest){
                ans=true;
                break;
            }
            for(int i=0;i<graph[vt].size();i++){
                if(!visited[graph[vt].get(i)]){
                    q.add(graph[vt].get(i));
                    visited[graph[vt].get(i)]=true;
                }
            }
        }
        
        return ans;
        
        
        
        
    }
    public static boolean hasPathDFS(ArrayList<Integer>[] graph,int src,int dest, boolean[] visited){
        
        
        
        if(src==dest){
            return true;
        }
        
        boolean ans=false;
        
        for(int i=0;i<graph[src].size();i++){
            // System.out.println(ans+" "+i);
            if(visited[graph[src].get(i)]==true){
            continue;
            }
            visited[graph[src].get(i)]=true;
            ans=ans||hasPathDFS(graph,graph[src].get(i),dest,visited);
            visited[graph[src].get(i)]=false;
        }
        return ans;
        
        
        
        
    }

}
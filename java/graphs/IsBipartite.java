import java.util.ArrayDeque;

class IsBipartite {
    class Pair{
        int vtx;
        int set;
        Pair(int vtx,int set){
            this.vtx=vtx;
            this.set=set;
        }
    }
    public boolean isBipartite(int[][] graph) {
        boolean[] visited=new boolean[graph.length];
        int[] set=new int[graph.length];
        ArrayDeque<Pair> q=new ArrayDeque<>();
        for(int i=0;i<graph.length;i++)
        {   
            if(visited[i]){
                continue;
            }
            q.add(new Pair(i,0));
            while(!q.isEmpty()){
                Pair rem=q.remove();
                if(visited[rem.vtx]){
                    continue;
                }
                visited[rem.vtx]=true;
                int myset=rem.set;
                int nbrset=myset==1?2:1;
                for(int nbr: graph[rem.vtx]){
                    if(!visited[nbr]){                   
                        if(set[nbr]==0 || set[nbr]==nbrset ){
                            q.add(new Pair(nbr,nbrset));
                            set[nbr]=nbrset;
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
        
    }
}
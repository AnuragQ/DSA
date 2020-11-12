import java.util.PriorityQueue;
class Solution  {
    class Pair implements Comparable<Pair>{
        double x;
        double y;
        double getDist(){
            return Math.sqrt(x*x+y*y);
        }
        Pair(double x,double y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Pair d) {
            return (this.getDist()>d.getDist()?1:-1);
        }

    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            pq.add(new Pair(points[i][0],points[i][1]));
        }
        int[][] ans=new int[K][2];
        for(int i=0;i<K;i++){
            Pair p=pq.remove();
            ans[i][0]=(int)p.x;
            ans[i][1]=(int)p.y;
        }
        return ans;
    }

}
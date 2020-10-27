package arrays;

// import java.io.BufferedReader;
// import java.io.InputStream;
// import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KSmallestSumPair {
    static class Pair{
        int num1;
        int num2;
        Pair(int num1,int num2){
            this.num1=num1;
            this.num2=num2;
        }
    }
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1={1,7,11};
        int[] arr2={2,4,6};
        int k=3;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.num1+y.num2-x.num1-x.num2);

        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(pq.size()<k){
                    pq.add(new Pair(arr1[i],arr2[j]));
                }
                else{
                    Pair p=pq.peek();
                    if(arr1[i]+arr2[j]<p.num1+p.num2){
                        pq.poll();
                        pq.add(new Pair(arr1[i],arr2[j]));
                    }
                }
            }
        }

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            System.out.println(p.num1+" "+p.num2);;
        }
    }

    
}
package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KSmallestOriginalOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split((" "));
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int k=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
            }
            else{
                if(pq.peek()>arr[i]){
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                System.out.print(arr[i]+" ");

            }else if(arr[i]==pq.peek()){
                System.out.print(arr[i]+" ");
                pq.poll();
            }
        }



        br.close();
    }
}
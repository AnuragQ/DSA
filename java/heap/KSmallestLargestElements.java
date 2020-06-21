package heap;

import java.io.*;
import java.util.*;

public class KSmallestLargestElements {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      PriorityQueue<Integer> pql=new PriorityQueue<>();
      PriorityQueue<Integer> pqs=new PriorityQueue<>((x,y)->y-x);
      
      for(int i=0;i<arr.length;i++){
          if(pql.size()<k){
              pql.add(arr[i]);
              pqs.add(arr[i]);
          }
          else{
              if(pql.peek()<arr[i]){
                  pql.poll();
                  pql.add(arr[i]);
              }
              if(pqs.peek()>arr[i]){
                pqs.poll();
                pqs.add(arr[i]);
            }
          }
      }
      System.out.println("Largest");
      for(int i=0;i<k;i++){
          System.out.println(pql.poll());
      }
      System.out.println("Smallest");
      for(int i=0;i<k;i++){
          System.out.println(pqs.poll());
      }
    }

}
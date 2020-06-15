package java.heap;

import java.io.*;
import java.util.*;

public class MergeKSortedArrayLists {
    static class Pair{
        int listNumber;
        int currentValue;
        int currentIndex;
        Pair(int listNumber,int currentValue,int currentIndex){
            this.listNumber=listNumber;
            this.currentValue=currentValue;
            this.currentIndex=currentIndex;
        }
    }
    
    
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      
      PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.currentValue-y.currentValue);
      
      int k=lists.size();
      for(int i =0; i<k;i++){
      
          
          pq.add(new Pair(i,lists.get(i).get(0),0));
      }
      while(!pq.isEmpty()){
          Pair p=pq.poll(); 
          if(p.currentIndex+1<lists.get(p.listNumber).size()){
              pq.add(new Pair(p.listNumber,lists.get(p.listNumber).get(p.currentIndex+1),p.currentIndex+1));
          }
          rv.add(p.currentValue);
        //   System.out.println(rv+" ");
      }
      
      
      
      // write your code here

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
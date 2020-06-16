import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

import java.util.HashMap;

public class test {
    class pair {
        int x;
        int y;
    }

    public static void main(String[] args) {
    LinkedList<Integer> li=new LinkedList<>();
    // st.peek();
    li.add(10);
    ArrayDeque<Integer> q= new ArrayDeque<>();
    q.add(10);
    q.add(20);
    q.add(30);
    // ArrayList<String> st
    System.out.println(q+" ");
    q.remove();
    System.out.println(q+" ");
    TreeMap<Integer,Character> hm=new TreeMap<Integer,Character>();
    hm.put(1, 'a');
    // hm.getO
    // hm.cont
    hm.pu
    for(Map.Entry<Integer,Character> entry:hm.entrySet()){
        System.out.print(entry.getKey());
    }
    for(char a:hm.values()){
        System.out.println(a);
    }
    System.out.println(hm.get(1));
    HashSet<Integer> hs=new HashSet<>();
    hs.add(1);
    hs.add(200);
    hs.add(30);
    hs.add(4000);
    hs.add(5);
    System.out.println(hs.contains(1));
    for(int i:hs){
        System.out.println(i);
    }
    hs.add(1);
    hs.contains(1);
    ArrayList<Integer> ar= new ArrayList<>();
    ar.add(1);
    // ar.remove(1);
    for(int i=0;i<10;i+=2){
        System.out.println(i);
    }
    TreeSet<Integer> ts=new TreeSet<>();
    ts.add(4);
    ts.add(7);
    ts.add(43);
    ts.add(9);
    ts.add(8);
    ts.add(1);
    ts.add(-6);
    System.out.println(ts);
    int[] arrnew = {9,2,3};
    Arrays.sort(arrnew);
    for (int i:arrnew){
        System.out.println(i);
    }
    System.out.print(-2);
    
    // HashMap<Integer,Integer> hm2=new HashMap<>();
    // hm2.con
    // PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
    // pq.add(11);
    // pq.add(20);
    // pq.poll();
    // if(pq.peek()==0){
    //     System.out.println("hi");
    // }
    // System.out.println(pq.peek());
    
    // System.out.println(pq.size());

    PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->x.x-y.x);
















    }

}
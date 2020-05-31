import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

// import hashmap.HashMap;

public class test {
    public static void main(String[] args) {
    LinkedList<Integer> li=new LinkedList<>();
    Stack<Integer>st=new Stack<>();
    // st.peek();
    li.add(10);
    ArrayDeque<Integer> q= new ArrayDeque<>();
    q.add(10);
    q.add(20);
    q.add(30);
    int[] x = new int[2];
    String[] arr=new String[2];
    // ArrayList<String> st
    System.out.println(q+" ");
    q.remove();
    System.out.println(q+" ");
    TreeMap<Integer,Character> hm=new TreeMap<Integer,Character>();
    hm.put(1, 'a');
    // hm.
    for(char a:hm.values()){
        System.out.println(a);
    }
    System.out.println(hm.get(1));

    ArrayList<Integer> ar= new ArrayList<>();
    ar.add(1);
    ar.remove(1);
    
    // PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
    // pq.add(11);
    // pq.add(20);
    // pq.poll();
    // if(pq.peek()==0){
    //     System.out.println("hi");
    // }
    // System.out.println(pq.peek());
    
    // System.out.println(pq.size());
    }
    
    
}
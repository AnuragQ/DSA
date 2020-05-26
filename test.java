import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

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
    System.out.println(q+" ");
    q.remove();
    System.out.println(q+" ");
        
    PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
    pq.add(11);
    pq.add(20);
    pq.poll();
    if(pq.peek()==0){
        System.out.println("hi");
    }
    System.out.println(pq.peek());
    
    System.out.println(pq.size());
    }
    
    
}
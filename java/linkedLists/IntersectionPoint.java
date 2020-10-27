import java.io.*;

public class IntersectionPoint {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;
    private Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp;
    }


    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size() {
      return size;
    }

   
public static int findIntersection(LinkedList one, LinkedList two){
  // write your code here
  Node fast,slow;
    if(one.size()>two.size()){
        slow=two.head;
          fast=one.head;
    }
    else{
          fast=two.head;
          slow=one.head;
    }
    int extra=Math.abs(one.size()-two.size());
    while(extra>0){
        extra--;
        fast=fast.next;
    }
    while(fast!=null){
        if(fast==slow){
            return fast.data;
        }
        fast=fast.next;
        slow=slow.next;
    }
      return -1;
}
   
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    LinkedList l1 = new LinkedList();
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      int d = Integer.parseInt(values1[i]);
      l1.addLast(d);
    }

    int n2 = Integer.parseInt(br.readLine());
    LinkedList l2 = new LinkedList();
    String[] values2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++) {
      int d = Integer.parseInt(values2[i]);
      l2.addLast(d);
    }

    int li = Integer.parseInt(br.readLine());
    int di = Integer.parseInt(br.readLine());
    if(li == 1){
      Node n = l1.getNodeAt(di);
      l2.tail.next = n;
      l2.tail = l1.tail;
      l2.size += l1.size - di;
    } else {
      Node n = l2.getNodeAt(di);
      l1.tail.next = n;
      l1.tail = l2.tail;
      l1.size += l2.size - di;
    }

    int inter = LinkedList.findIntersection(l1, l2);
    System.out.println(inter);
  }
}
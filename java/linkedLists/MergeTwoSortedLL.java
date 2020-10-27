import java.io.*;

public class MergeTwoSortedLL {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

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

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {

    LinkedList l=new LinkedList();
    Node temp1=l1.head;
    Node temp2=l2.head;
    while(temp1!=null && temp2!=null){
        if(temp1.data<temp2.data){
            l.addLast(temp1.data);
            temp1=temp1.next;
        }else{
            l.addLast(temp2.data);
            temp2=temp2.next;
        }
    }
    while(temp1!=null){
        l.addLast(temp1.data);
        temp1=temp1.next;
    }
    while(temp2!=null){
        l.addLast(temp2.data);
        temp2=temp2.next;
    }
    return l;
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

    LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
    merged.display();
    l1.display();
    l2.display();
  }
}
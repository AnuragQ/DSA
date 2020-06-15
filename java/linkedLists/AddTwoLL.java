import java.io.*;
/**
 * Approach 1 - (recursion only) - at each level if their place value is same then add else increase place value
 *                                 of the linked list with higher place value
 * 
 * 
 * 
 * Approach 2 - iteration +recusrsion TODO
                    iterate through the bigger list until their size gets same 
                    add two linked lists and in the end if carry is generated add it as well




**/

public class AddTwoLL {
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


    public void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = head;
      head = temp;

      if (size == 0) {
        tail = temp;
      }

      size++;
    }
   
    private static int addTwoLists(Node one,Node two,int pv1,int pv2,LinkedList ans){
        if(one==null && two==null){
            
            return 0;
        }
        int carry,data;
        
        
        if(pv1==pv2){
            carry=addTwoLists(one.next,two.next,pv1-1,pv2-1,ans);
            data=one.data+two.data+carry;
        }else if(pv1<pv2){
            carry=addTwoLists(one,two.next,pv1,pv2-1,ans);
            data=two.data+carry;
        }else {
            carry=addTwoLists(one.next,two,pv1-1,pv2,ans);
            data=one.data+carry;
        }
        
        carry=data/10;
        ans.addFirst(data%10);
        return carry;
        
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      // write your code here
      
      LinkedList ans=new LinkedList();
      int carry=addTwoLists(one.head,two.head,one.size(),two.size(),ans);
      if(carry>0){
          ans.addFirst(carry);
      }
      return ans;
      
      
      
    }
  }

  public static void main(String[] args) throws Exception {
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

    LinkedList sum = LinkedList.addTwoLists(l1, l2);

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    l1.display();
    l2.display();
    sum.display();
    sum.addFirst(a);
    sum.addLast(b);
    sum.display();
  }
}
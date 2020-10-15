// https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
// https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}

class GfG
{   int max = Integer.MIN_VALUE;
    Node compute(Node head)
    {
        if(head==null){
            return null;
        }
        head.next=compute(head.next);
        if(head.data<max){
            return head.next;
        }
        max=Math.max(max,head.data);
        return head;
        // your code here
        
    }
}
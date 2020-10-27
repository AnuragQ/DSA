import java.io.*;

public class IsPalindrome {
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
    class pairPal {
      Node n2u;
      boolean isPalindrome;
  }



public pairPal IsPalindrome(Node node, Node n2u) {
  if (node.next == null) {
    pairPal p = new pairPal();
    p.n2u = n2u.next;
    if (node.data == n2u.data) {
      p.isPalindrome = true;
    } else {
      p.isPalindrome = false;
    }
    return p;
  }
  pairPal ret = IsPalindrome(node.next, n2u);
  if (ret.isPalindrome) {
    if (node.data == ret.n2u.data) {
      ret.n2u = ret.n2u.next;
      return ret;
    } else {
      ret.isPalindrome = false;
      return ret;
    }
  } else {
    return ret;
  }

}

    public boolean IsPalindrome() {
      // write your code here
      return IsPalindrome(head, head).isPalindrome;
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

    System.out.println(l1.IsPalindrome());
  }
}
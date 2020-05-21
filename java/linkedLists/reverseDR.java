import java.io.*;

public class reverseDR {
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

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        private Node reverseDR(Node node, Node n2u) {
            if (node.next == null) {
                n2u.data = node.data;
                return n2u.next;
            }
            int newData = node.data;
            n2u = reverseDR(node.next, n2u);
            n2u.data = newData;
            return n2u.next;
        }

        public void reverseDR() {
            // write your code here
            reverseDR(head, head);
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

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l1.reverseDR();
        l1.addLast(a);
        l1.addFirst(b);
        l1.display();
    }
}
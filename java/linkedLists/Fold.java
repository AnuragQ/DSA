import java.io.*;

public class Fold {
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

        public Node reverse(Node node) {
            Node cur = node, prev = null;

            while (cur != null) {
                Node next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;

            }
            return prev;
        }

        public void fold() {
            // write your code here
            Node node = this.head;
            Node slow = node;
            Node fast = node;
            while (fast != null && fast.next != null) {
                // System.out.println(fast.data);
                slow = slow.next;
                fast = fast.next.next;
            }
            Node right = slow.next;
            slow.next = null;

            right = reverse(right);
            Node dum = new Node();
            Node cur = dum;
            Node tail = null;
            while (node != null || right != null) {
                if (node != null) {
                    cur.next = node;
                    cur = cur.next;
                    node = node.next;
                    if (cur != null)
                        tail = cur;

                }
                if (right != null) {
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                    if (cur != null)
                        tail = cur;

                }
                // System.out.println(tail.data);

            }
            this.tail = tail;
            this.head = dum.next;

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

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l1.fold();
        l1.display();
        l1.addFirst(a);
        l1.addLast(b);
        l1.display();
    }
}
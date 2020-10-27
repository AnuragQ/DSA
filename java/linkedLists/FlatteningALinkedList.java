
/*  Function which returns the  root of 
    the flattened linked list. */
class FlatteningALinkedList

{
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node merge(Node a, Node b) {

        Node temp = new Node(0);
        Node dum = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                dum.bottom = a;
                a = a.bottom;
                dum = dum.bottom;
            } else {
                // System.out.println("hi");
                dum.bottom = b;
                b = b.bottom;
                dum = dum.bottom;
            }
        }

        while (a != null) {
            // System.out.println(a.data);

            dum.bottom = a;
            a = a.bottom;
            dum = dum.bottom;
        }
        while (b != null) {
            // System.out.println(b.data);
            dum.bottom = b;
            b = b.bottom;
            dum = dum.bottom;
        }
        return temp.bottom;
    }

    Node flatten(Node root) {
        if (root == null) {
            return null;
        }
        Node ret = flatten(root.next);

        return merge(root, ret);

    }
}
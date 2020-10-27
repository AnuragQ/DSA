
//This function should return head to the DLL

class BinaryTreeToDLL {
    class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }

    }

class Pair {
    Node head;
    Node tail;
}

Node bToDLL(Node root) {
    // Your code here
    return bToDLLHelper(root).head;
    // Node right=bToDLL(root.right);
}

Pair bToDLLHelper(Node root) {
    Pair mypair = new Pair();

    if (root.left != null) {
        Pair left = bToDLLHelper(root.left);
        left.tail.right = root;
        mypair.head = left.head;
        root.left = left.tail;
    } else {
        mypair.head = root;
    }
    if (root.right != null) {
        Pair right = bToDLLHelper(root.right);
        right.head.left = root;
        mypair.tail = right.tail;
        root.right = right.head;
    } else {
        mypair.tail = root;
    }
    return mypair;
}
}
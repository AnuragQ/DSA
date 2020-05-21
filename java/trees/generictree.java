package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class generictree {
    public class Node {
        int data;
        List<Node> children;

        // Node[] children;
        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.data + "";
        }
    }

    public generictree(int[] arr) {
        Stack<Integer> entries = populateStack(arr);
        this.root = populateGetChild(entries);
    }

    int size;
    private Node root;

    private Node populateGetChild(Stack<Integer> entries) {
        Node node = new Node(entries.pop());
        this.size++;

        while (entries.peek() != -1) {
            node.children.add(populateGetChild(entries));

        }
        entries.pop();
        return node;

    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        System.out.println(node.data + " children are ");
        System.out.println(node.children);
        for (Node child : node.children)
            display(child);
    }

    private Stack<Integer> populateStack(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--)
            st.push(arr[i]);
        return st;
    }

    public int size() {
        return this.size;
    }

    public int size2() {
        return size2(this.root);
    }

    private int size2(Node node) {
        int mySize = 1;
        for (Node child : node.children)
            mySize += size2(child);
        return mySize;

    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {
        int max = node.data;
        for (Node child : node.children) {
            max = Math.max(max, max(child));
        }
        return max;
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        int height = 0;
        for (Node child : node.children) {
            height = Math.max(height(child), height);
        }
        return height + 1;
    }

    public void prepostpep() {
        prepostpep(this.root);
    }

    private void prepostpep(Node node) {
        System.out.println("Node Pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);

        }
        System.out.println("Node Post " + node.data);

    }

    private void traversals(Node child) {
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        System.out.println(node.data);
        for (Node child : node.children) {
            preOrder(child);
        }
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node node) {
        for (Node child : node.children) {
            postOrder(child);
        }

        System.out.println(node.data);

    }

    public void levelOrder() {
        levelOrder(this.root);
    }

    private void levelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        // queue.
        while (!queue.isEmpty()) {
            Node parent = queue.removeFirst();
            System.out.println(parent.data);
            for (Node child : parent.children) {
                queue.addLast(child);
            }
        }
    }

    public void levelOrderLineWiseNull() {
        levelOrderLineWiseNull(this.root);
    }

    private void levelOrderLineWiseNull(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            Node parent = queue.removeFirst();
            System.out.println(parent.data);
            for (Node child : parent.children) {
                queue.addLast(child);
            }
        }
    }

    public void levelOrderLineWiseSize() {
        levelOrderLineWiseSize(this.root);
    }

    private void levelOrderLineWiseSize(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node removed = queue.removeFirst();
                System.out.print(removed.data + " ");
                for (Node child : removed.children) {
                    queue.addLast(child);
                }
                size--;
            }
            System.out.println();
        }
    }

    public void mirror() {
        mirror(this.root);
    }

    private void mirror(Node node) {
        Collections.reverse(node.children);
        for (Node child : node.children) {
            mirror(child);
        }
    }

}

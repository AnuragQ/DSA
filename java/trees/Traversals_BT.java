package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Traversals_BT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void levelOrder(Node node) {
        ArrayDeque<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while (mq.size() > 0) {
            int cicl = mq.size();

            for (int i = 0; i < cicl; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    mq.add(node.left);
                }

                if (node.right != null) {
                    mq.add(node.right);
                }
            }

            System.out.println();
        }
    }
    public static class TPair {
        Node node;
        int state;
        TPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void iterativePrePostInTraversal(Node node) {
        String preorder = "", inorder = "", postorder = "";

        Stack < TPair > st = new Stack < > ();

        st.push(new TPair(node, 1));

        while (!st.isEmpty()) {
            TPair p = st.pop();
            if (p.state == 1) {
                p.state = 2;
                st.push(p);
                if (p.node.left != null)
                    st.push(new TPair(p.node.left, 1));
                preorder = preorder + p.node.data + " ";
            } else if (p.state == 2) {
                p.state = 3;
                st.push(p);
                if (p.node.right != null)

                    st.push(new TPair(p.node.right, 1));
                inorder = inorder + p.node.data + " ";

            } else {
                postorder = postorder + p.node.data + " ";
            }
        }
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);



        // write your code here
    }



    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        Node root = construct(arr);
        levelOrder(root);
        iterativePrePostInTraversal(root);

      }
    
}
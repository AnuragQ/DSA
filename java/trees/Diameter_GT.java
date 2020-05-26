package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Diameter_GT {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static class diaPair {
        int maxDia;
        int myHeight;
    }

    public static diaPair getDiameter(Node node) {
        diaPair myans = new diaPair();

        if (node == null) {
            myans.myHeight = -1;
            myans.maxDia = -1;
            return new diaPair();
        }
        int highest = -1;
        int scondHighest = -1;
        if (node.children.size() != 1) {
            for (Node child : node.children) {
                diaPair ch = getDiameter(child);
                if (ch.myHeight >= highest) {
                    scondHighest = highest;
                    highest = ch.myHeight;
                } else if (ch.myHeight >= scondHighest) {
                    scondHighest = ch.myHeight;
                }
                myans.maxDia = Math.max(myans.maxDia, ch.maxDia);
            }
            myans.myHeight = highest + 1;
            myans.maxDia = Math.max(myans.maxDia, highest + scondHighest + 2);
            return myans;
        } else if (node.children.size() == 1) {
            diaPair childans = getDiameter(node.children.get(0));
            myans.maxDia = Math.max(childans.maxDia, childans.myHeight + 1);
            myans.myHeight = childans.myHeight + 1;
            return myans;
        } else {
            myans.myHeight = 0;
            myans.maxDia = 1;
            return myans;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        diaPair p = getDiameter(root);
        System.out.println(p.maxDia );
    }

}
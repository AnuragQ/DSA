// https://www.geeksforgeeks.org/construct-tree-from-ancestor-matrix/

import java.io.*;

// import jdk.internal.jline.internal.InputStreamReader;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {

        this.data = data;
    }
}

public class BTreeFromAncestorMatrix {

    // 6
    // 0 0 0 0 0 0
    // 1 0 0 0 1 0
    // 1 1 0 1 1 1
    // 0 0 0 0 0 0
    // 0 0 0 0 0 0
    // 0 0 0 1 0 0

    // 6
    // 0 0 0 0 0 0
    // 1 0 0 0 1 0
    // 0 0 0 1 0 0
    // 0 0 0 0 0 0
    // 0 0 0 0 0 0
    // 1 1 1 1 1 0

    // 3
    // 0 1 1
    // 0 0 0
    // 0 0 0

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] childCount = new int[n];
        int[][] arr = new int[n][n];
        int max = Integer.MIN_VALUE;
        int root = -1;
        for (int i = 0; i < n; i++) {

            String[] inp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(inp[j]);
                if (arr[i][j] == 1) {
                    childCount[i] += 1;
                    if (childCount[i] > max) {
                        max = childCount[i];
                        root = i;
                    }
                }
            }
        }
        int[] anscestor = new int[n];
        for (int i = 0; i < n; i++) {
            anscestor[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                if (anscestor[j] == -1 || childCount[anscestor[j]] > childCount[i]) {
                    anscestor[j] = i;
                }
            }
        }

        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }
        for (int i = 0; i < n; i++) {
            if (anscestor[i] == -1) {
                continue;
            }
            if (nodes[anscestor[i]].left == null) {
                nodes[anscestor[i]].left = nodes[i];

            } else {
                nodes[anscestor[i]].right = nodes[i];
            }
        }

        display(nodes[root]);

    }

    private static void display(TreeNode node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left != null ? node.left.data : ".";
        str += "->" + node.data + "<-";
        str += node.right != null ? node.right.data : ".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}

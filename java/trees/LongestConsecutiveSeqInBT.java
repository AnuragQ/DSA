import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class GfG {
public int longestConsecutive(Node root) {
    longestConsecutive(root, new ArrayList<>());
    return this.best == 1 ? -1 : this.best;

}

int best;

public void longestConsecutive(Node root, ArrayList<Integer> psf) {
    if (psf.size() > best) {
        best = psf.size();
    }
    // add code here.
    if (root == null) {
        return;
    }
    if (psf.size() == 0 || root.data == psf.get(psf.size() - 1) + 1) {

    } else {
        psf = new ArrayList<>();

    }
    psf.add(root.data);

    longestConsecutive(root.left, psf);
    longestConsecutive(root.right, psf);
    psf.remove(psf.size() - 1);

}

// O(1) space
public int longestConsecutiveO1space(Node root) {
    longestConsecutive(root, -1, 0);
    return this.best == 1 ? -1 : this.best;

}


public void longestConsecutive(Node root, int prev, int length) {
    if (length > best) {
        best = length;
    }
    // add code here.
    if (root == null) {
        return;
    }
    if (prev == -1 || root.data == prev + 1) {

    } else {
        length = 0;

    }
    length += 1;

    longestConsecutive(root.left, root.data, length);
    longestConsecutive(root.right, root.data, length);
    // psf.remove(psf.size()-1);

}

}
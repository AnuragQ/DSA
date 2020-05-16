package java.trees;

import java.util.ArrayList;

public class genericTreeDriver {
    public static void main(String[] args) {
        int[] arr={1,2,5,-1,6,-1,-1,3,-1,4,7,-1,8,9,-1,-1,-1,-1};
        generictree gt=new generictree(arr);
        gt.display();
        gt.levelOrder();
        gt.mirror();
        gt.levelOrder();
        System.out.println(true|false);
        ArrayList<Integer> array=new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        ArrayList<Integer> newarray=new ArrayList<>();
        newarray.addAll(array);
        System.out.println(array.isEmpty());
    }
}
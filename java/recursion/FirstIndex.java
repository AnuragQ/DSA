// package java.recursion;

import java.util.*;

public class FirstIndex {

    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);
        int size=sc.nextInt();
        int[] array=new int[size];
        for (int i=0;i<size;i++){
            array[i]=sc.nextInt();
            
        }
        int num=sc.nextInt();
        sc.close();
        System.out.print(firstIndex(array,0,num));
        // write your code here
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx==arr.length){
            return -1;
        }
         
        if(arr[idx]==x){
            return idx;
        }
        int index=firstIndex(arr,idx+1,x);
        return index;
    }

}
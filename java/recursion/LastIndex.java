
import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);
        int size=sc.nextInt();
        int[] array=new int[size];
        for (int i=0;i<size;i++){
            array[i]=sc.nextInt();
            
        }
        int num=sc.nextInt();
        sc.close();
        System.out.print(lastIndex(array,0,num));
        // write your code here
    }

public static int lastIndex(int[] arr, int idx, int x){
    if(idx==arr.length){
        return -1;
    }
    int index=lastIndex(arr,idx+1,x);
    if(index!=-1){
        return index;
    }
    if(arr[idx]==x){
        return idx;
    }
    
    return index;
}

}
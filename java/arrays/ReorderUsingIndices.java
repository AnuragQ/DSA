package arrays;

// Input:  arr[]   = [50, 40, 70, 60, 90]
//         index[] = [3,  0,  4,  1,  2]
// Output: arr[]   = [40, 60, 90, 50, 70]
//         index[] = [0,  1,  2,  3,   4] 

// Input:  arr[]   = [10, 11, 12];
//         index[] = [1, 0, 2];
// Output: arr[]   = [11, 10, 12]
//         index[] = [0,  1,  2] 

public class ReorderUsingIndices {
    public static void main(String[] args) {
        int[] arr   = {50, 40, 70, 60, 90};
        int[] index = {3,  0,  4,  1,  2};
        int idx=0;
        while(idx<arr.length){
            while(idx!=index[idx]){
                int temp=arr[index[idx]];
                arr[index[idx]]=arr[idx];
                arr[idx]=temp;
                // System.out.println(arr[index[idx]]+" "+arr[idx]);
                temp=index[index[idx]];
                index[index[idx]]=index[idx];
                index[idx]=temp;
                // System.out.println(arr[idx]);


            }
            idx++;
        }
        for(int i =0; i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
        for(int i =0; i<arr.length;i++){
            System.out.print(index[i]+" ");

        }



    }
}
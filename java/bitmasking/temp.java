class Solution {
    public static void insert(int arr[],int temp){
        int i=0;
        while((i+1)<arr.length && arr[i+1]<temp){
            arr[i]=arr[i+1];
            i++;
        }
        arr[i]=temp;
    }
    public static void merge(int arr1[], int arr2[]) {
        // code here
        int i=0;
        int j=0;
        while(i<arr1.length){
            System.out.println(i);
            if(arr1[i]<arr2[j]){
                i++;
            }else{
                int temp=arr1[i];
                arr1[i]=arr2[j];
                insert(arr2,temp);
            }
        }
        System.out.println("==========");
        for(int data:arr1){
            System.out.println(data);
        }
        for(int data:arr2){
            System.out.println(data);
        }
        
        
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        merge(arr1,arr2);
    }
}
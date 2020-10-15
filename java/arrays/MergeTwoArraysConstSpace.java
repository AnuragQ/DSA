
class MergeTwoArraysConstSpace {
    public  void insert(int arr[],int temp){
        int i=arr.length-1;
        while((i-1)>=0 && arr[i-1]>=temp){
            arr[i]=arr[i-1];
            i--;
        }
        arr[i]=temp;
    }
    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i=arr2.length-1;
        while(i>=0){
            if(arr1[arr1.length-1]<=arr2[i]){
                i--;
            }else{
                int temp=arr2[i];
                arr2[i]=arr1[arr1.length-1];
                insert(arr1,temp);
            }
        }
        
    }
    // public  void insert(int arr[],int temp){
    //     int i=0;
    //     while((i+1)<arr.length && arr[i+1]<temp){
    //         arr[i]=arr[i+1];
    //         i++;
    //     }
    //     arr[i]=temp;
    // }
    // public void merge(int arr1[], int arr2[], int n, int m) {
    //     // code here
    //     int i=0;
    //     int j=0;
    //     while(i<arr1.length){
    //         if(arr1[i]<arr2[j]){
    //             i++;
    //         }else{
    //             int temp=arr1[i];
    //             arr1[i]=arr2[j];
    //             insert(arr2,temp);
    //         }
    //     }
        
    // }
}
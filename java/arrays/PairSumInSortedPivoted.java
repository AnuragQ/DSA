public class PairSumInSortedPivoted {
    public static void main(String[] args) {
        int[] arr={15,26,37,48,1,2,3,4};
        int target=138;
        int start=0;
        int end=arr.length-1;
        int mid=0;
        int pivot=0;
        while(start<end){
		      
            mid=(start+end)/2;
            
            if(arr[mid]>arr[start] && arr[mid]>arr[end]){
                if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
                    start=mid+1;
                }else{
                    pivot=mid;
                    break;
                }
            }else if(arr[mid]<arr[end]  && arr[mid]<arr[start] ){
                if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
                    end=mid-1;
                }else{
                    pivot=mid;
                    break;
                }
            }
        }
           
        int left=pivot;
        int right=pivot-1;
        int sum=0;
        boolean found=false;
        while(left!=right){
            left=(left+arr.length)%arr.length;
            right=(right+arr.length)%arr.length;

            sum=arr[left]+arr[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else if(sum==target){
                found=true;
                break;
            }
        }
        System.out.println(found);


    }
}

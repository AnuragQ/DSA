class MaximumSwap {
    public int maximumSwap(int num) {
        int[] arr=new int[Integer.toString(num).length()];
        int i=arr.length-1;
        while(num>0){
            arr[i]=num%10;
            num/=10;
            i--;
        }
        int[] locc=new int[10];
        for(i=0;i<arr.length;i++){
            locc[arr[i]]=i;
        }
    
        for(i=0;i<arr.length;i++){
            boolean found=false;
            for(int j=9;j>arr[i];j--)  {
                if(locc[j]>i){
                    //swap
                    int temp=arr[i];
                    arr[i]=arr[locc[j]];
                    arr[locc[j]]=temp;
                    found=true;
                    break;
                }
            }  
            if(found){
                break;
            }
            
        }
        int ans=0;
        for( i=0;i<arr.length;i++){
            ans=ans*10+arr[i];
        }
        return ans;
        
        
    }
}
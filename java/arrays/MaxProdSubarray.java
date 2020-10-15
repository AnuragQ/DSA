
class MaxProdSubarray {
    public int maxProduct(int[] nums) {
        int max=nums[0],curmax=nums[0],curmin=nums[0];
        for(int i=1;i<nums.length;i++){
            int mx=Math.max(nums[i],Math.max(nums[i]*curmax,nums[i]*curmin));
            int mi=Math.min(nums[i],Math.min(nums[i]*curmin,nums[i]*curmax));
            curmax=mx;
            curmin=mi;
            max=Math.max(max,Math.max(mx,mi));
        }
        
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]>0){
//                 if(nums[i]>curmax*nums[i]){
//                     curmax=nums[i];
//                     curmin=nums[i];
//                 }else{
//                     curmax=curmax*nums[i];
//                     curmin=Math.min(curmin,curmin*nums[i]);
//                 }
//             }else{
//                 if()
//             }
//         }
        
        
        
        return max;
        
    }
}
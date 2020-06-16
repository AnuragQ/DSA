package arrays;

class KadanrsMaxSum {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE,cur=0;
        for(int i=0;i<nums.length;i++){
            if(cur+nums[i]>nums[i]){
                cur=cur+nums[i];
            }
            else{
                cur=nums[i];
            }
            if(cur>maxSum){
                maxSum=cur;
            }
        }
        return maxSum;
    }
}
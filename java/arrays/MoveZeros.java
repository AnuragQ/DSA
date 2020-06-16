package arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(j>=i && i<nums.length && j<nums.length){
            if(nums[i]!=0){
                i++;
                j++;
            }else{
                if(nums[j]==0){
                    j++;
                }else{
                    nums[i]=nums[j];
                    nums[j]=0;
                    i++;
                    j++;
                }
            }
        }
    }
}
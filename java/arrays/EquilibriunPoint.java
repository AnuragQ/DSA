package java.arrays;

class EquilibriunPoint {
    public int pivotIndex(int[] nums) {
        int[] rightsum= new int[nums.length];
        
        for (int i =nums.length-2 ; i>=0;i--){
            rightsum[i]=rightsum[i+1]+nums[i+1];
        }
        int leftsum=0;
        for (int i=0;i<nums.length;i++){
            if(rightsum[i]==leftsum){
                return i;
            }
            leftsum+=nums[i];
        }
        
        return -1;
    }
}
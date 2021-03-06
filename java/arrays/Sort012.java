package arrays;

// import java.util.*;
// import java.lang.*;
import java.io.*;


    
    




public class Sort012 {

public void sortColors(int[] nums) {
    
    // 000000111111_______22222
    //       ^     ^     ^      
    //       |     |     |
    //       lo    mid   hi
    
    
    int lo=0,mid=0,hi=nums.length-1;
    while(mid<=hi){
        if(nums[mid]==0){
            //swap lo mid
            int temp=nums[lo];
            nums[lo]=nums[mid];
            nums[mid]=temp;
            
            lo++;
            mid++;
        }else if(nums[mid]==1){
            mid++;
        }else{
            //swap hi mid
            int temp=nums[hi];
            nums[hi]=nums[mid];
            nums[mid]=temp;
            
            hi--;
        }
    }
    
}


	/* package whatever //do not write package name here */

	public static void main(String[] args) throws IOException {
		// code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int n = Integer.parseInt((br.readLine()));
			String[] inp = br.readLine().split(" ");
			int[] nums = new int[inp.length];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(inp[i]);
			}
			int i=0,t=nums.length,z=-1;
        while(i<nums.length && t>=0 && z<nums.length && t>i){
            if(nums[i]==0){
                z++;
                int temp=nums[i];
                nums[i]=nums[z];
                nums[z]=temp;
                i++;
            }else if(nums[i]==2){
                t--;
                int temp=nums[i];
                nums[i]=nums[t];
                nums[t]=temp;
            }else if(nums[i]==1){
                i++;
            }
        }
        for ( i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();

		}

		br.close();

	}
}

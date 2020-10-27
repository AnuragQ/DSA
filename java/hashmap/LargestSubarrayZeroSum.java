import java.util.*;

public class LargestSubarrayZeroSum {
	
	public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=-1;
        hm.put(0,-1);
        int maxLength=0;
        int curSum=0;
        while(i<arr.length-1){
            i++;
            curSum+=arr[i];
            if(!hm.containsKey(curSum)){
                hm.put(curSum,i);
            }else{
                int lastIdx=hm.get(curSum);
                maxLength=Math.max(maxLength,i-lastIdx);
            }
        }
		return maxLength;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}

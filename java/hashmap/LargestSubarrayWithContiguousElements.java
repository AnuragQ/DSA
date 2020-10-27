import java.util.*;

public class LargestSubarrayWithContiguousElements {

	public static int solution(int[] arr) {
	    
        int length=0;
        for(int i=0;i<arr.length;i++){
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            HashSet<Integer> hs=new HashSet<Integer>();
            
            for(int j=i;j<arr.length;j++){
                if(hs.contains(arr[j]) || (max>min && arr[j]>=arr.length+max)){
                    break;
                }
                
                hs.add(arr[j]);
                
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                
                if(max-min==j-i){
                    length=Math.max(length,max-min+1);
                }
                
            }
        }
		return length;
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

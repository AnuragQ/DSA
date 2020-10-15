import java.util.*;
 
 public class GrayCode {
 
     public static List<Integer> grayCode(int n) {
 	 //Write your code here
 	 List<Integer> ans=new ArrayList<>();
 	    if(n==0){
 	        ans.add(0);
 	        return ans;
 	    }

 	    List<Integer> prev=grayCode(n-1);
 	    ans.addAll(prev);
 	    for(int i=prev.size()-1;i>=0;i--){
 	        ans.add((1<<(n-1))+prev.get(i));
 	    }
 	    return ans;
     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 }
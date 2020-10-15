import java.util.*;

public class WildcardPatternMatching {

	public static boolean solution(String s, String p) {
		//write your code here
		boolean[][] dp=new boolean[p.length()+1][s.length()+1];
        
        dp[p.length()][s.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            for(int j=s.length();j>=0;j--){
                if(j<s.length() && p.charAt(i)=='?'){
                    dp[i][j]=dp[i+1][j+1];
                }else if(p.charAt(i)=='*'){
                    dp[i][j]=dp[i+1][j];
                    if(j<s.length()){
                        dp[i][j]|=dp[i][j+1];
                    }
                        
                    
                }else if(j<s.length() && p.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                    
                }
            }
        }
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[i].length;j++){
        //         System.out.print(dp[i][j]+(dp[i][j]?"  ":" "));
        //     }
        //     System.out.println();
        // }
        return dp[0][0];
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
        System.out.println(solution(s1,s2));
        scn.close();
	}

}
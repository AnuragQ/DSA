import java.util.*;

public class LongestPalindromicSubsequence_iter {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        sc.close();
        
        
        int[][] dp=new int[str.length()][str.length()];
        
        for(int diff=0;diff<str.length();diff++){
            for(int i=0,j=diff;j<str.length() ;i++,j++){
            
                
                
                if(diff==0){
                    dp[i][j]=1;
                }else if(diff==1){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=1;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
                
            }
        }
 
     System.out.println(dp[0][str.length()-1]);   
        
    }

}
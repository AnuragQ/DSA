import java.util.*;

public class LCS_iter {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
        
        sc.close();
    }   

}
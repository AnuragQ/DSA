import java.util.*;

public class LongestPalindromicSubstring_iter {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        // System.out.println(s1+s2);
        int length=0;
        boolean[][] dp=new boolean[str.length()][str.length()];
        for(int diff=0;diff<str.length();diff++){
            int j=diff;
            for(int i=0; j<str.length();i++){
                if(diff==0){
                    length=diff+1;
                    dp[i][j]=true;
                }else if(diff==1){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=true;
                        length=diff+1;
                        
                    }
                        
                }else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                        length=diff+1;
                    }
                }
                j++;
            
            }
        }
        System.out.println(length);
        sc.close();
    }   

}
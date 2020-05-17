
import java.io.*;

public class PrintPermutations {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printPermutations(str, "");
    }

    public static void printPermutations(String str,String ans) {
        if(str.length()==0){
            System.out.println(ans);
        }
        for(int i=0; i<str.length();i++){
            printPermutations(str.substring(0,i)+str.substring(i+1),ans+str.charAt(i));
            
        }

    }

}
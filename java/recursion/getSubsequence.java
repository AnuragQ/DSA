package java.recursion;

import java.util.*;

public class getSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        sc.close();
        // System.out.print(str);
        ArrayList<String> ans=gss(str);
        System.out.print(ans    );
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            return new ArrayList<>(Arrays.asList(""));
        }
        ArrayList<String> s1=gss(str.substring(1));
        int size=s1.size();
        for(int i=0; i<size;i++){
            s1.add(str.charAt(0)+s1.get(i));
        }
        // s1.addAll(gss);
        return s1;
    }

}
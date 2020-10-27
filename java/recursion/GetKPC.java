// package java.recursion;

import java.io.*;
import java.util.*;

public class GetKPC {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }
// ArrayList<String> words = getKPC(str);
static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

public static ArrayList<String> getKPC(String str) {
    if (str.length() == 0) {
        return new ArrayList<>(Arrays.asList(""));
    }

    ArrayList<String> awk = getKPC(str.substring(1));
    ArrayList<String> ans = new ArrayList<String>();
    String code = codes[str.charAt(0) - '0'];
    for (int i = 0; i < code.length(); i++) {
        for (int j = 0; j < awk.size(); j++) {
            ans.add(code.charAt(i) + awk.get(j));
        }
    }
    return ans;
}

}
import java.io.*;
import java.util.*;

public class WordsKLength1 {

  public static void generateWords(int cc, String ustr, int ssf, int ts, Character[] spots) {
    // write your code here
    
    if(cc>=ustr.length()){
        if(ssf==ts){
            for(int i=0;i<spots.length;i++)
                System.out.print(spots[i]);
            System.out.println();
        }
        return;
    }
    
    for(int i=0;i<spots.length;i++){
        if(spots[i]==null){
            spots[i]=ustr.charAt(cc);
            generateWords(cc+1,ustr,ssf+1,ts,spots);
            spots[i]=null;
        }
    }
    generateWords(cc+1,ustr,ssf,ts,spots);
    
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    Character[] spots = new Character[k];
    generateWords(0, ustr, 0, k, spots);
  }

}
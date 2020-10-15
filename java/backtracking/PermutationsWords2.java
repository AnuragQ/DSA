import java.io.*;
import java.util.*;

public class PermutationsWords2 {

  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {
    // write your code here
    
    if(cc==str.length()){
        for(int i=0;i<spots.length;i++){
            System.out.print(spots[i]);
            
        }
        System.out.println();
        return;
    }
    // a little optimised
    int lo=lastOccurence.get(str.charAt(cc));
    for(int i=lo+1;i<spots.length;i++){
        if(spots[i]==null ){
            
            lastOccurence.put(str.charAt(cc),i);
            spots[i]=str.charAt(cc);
            generateWords(cc+1,str,spots,lastOccurence);
            lastOccurence.put(str.charAt(cc),lo);
            spots[i]=null;
        }
    }
    
    // for(int i=0;i<spots.length;i++){
    //     if(spots[i]==null && lastOccurence.get(str.charAt(cc))<i){
    //         int lo=lastOccurence.get(str.charAt(cc));
    //         lastOccurence.put(str.charAt(cc),i);
    //         spots[i]=str.charAt(cc);
    //         generateWords(cc+1,str,spots,lastOccurence);
    //         lastOccurence.put(str.charAt(cc),lo);
    //         spots[i]=null;
    //     }
    // }
    
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}
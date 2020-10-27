import java.io.*;
import java.util.*;
import java.util.HashMap;


public class NumerOfValidWords {
    public static int getMask(String str){
        int mask=0;
        for(int j=0;j<str.length();j++){
            mask=mask | (1<<str.charAt(j));
        }
        return mask;
    }

    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //write your code here
        
        
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<26;i++){
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<words.length;i++){
            String word=words[i];
            int mask=getMask(word);
            HashSet<Character> hs=new HashSet<>();
            
            for(int j=0;j<word.length();j++){
                
                char ch=word.charAt(j);
                if(hs.contains(ch))
                    continue;
                
                hm.get(ch-'a').add(mask);
                hs.add(ch);
                
            }
        }
        ArrayList<Integer> count=new ArrayList<>();
        for(int i=0;i<puzzles.length;i++){
            String puzzle=puzzles[i];
            ArrayList<Integer> arr=hm.get(puzzle.charAt(0)-'a');
            int mask=getMask(puzzle);
            int c=0;
            for(int j:arr)
                if( (j&mask) == j )
                    c++;
                
            count.add(c);
        }
        
        return count;
        
        // my approach
        
        // int[] wordmasks=new int[words.length];
        // for(int i=0;i<words.length;i++){
        //     String word=words[i];
        //     for(int j=0;j<word.length();j++){
        //         char ch=word.charAt(j);
        //         wordmasks[i]=(wordmasks[i]) | (1<<(ch-'a'));
        //     }
            
        // }
        // int[] puzzlemasks=new int[puzzles.length];
        // for(int i=0;i<puzzles.length;i++){
        //     String puzzle=puzzles[i];
        //     for(int j=0;j<puzzle.length();j++){
        //         char ch=puzzle.charAt(j);
        //         puzzlemasks[i]=puzzlemasks[i] | (1<<(ch-'a'));
        //     }
            
        // }
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int j=0;j<puzzles.length;j++){

        //     int count=0;
        //     for(int i=0;i<words.length;i++){
        //         if((wordmasks[i] & ( 1<<(puzzles[j].charAt(0)-'a'))) != 0){
        //             if( (puzzlemasks[j] & wordmasks[i]) == wordmasks[i] ){
        //                 count++;
        //             }
        //         }
        //     }
        //     ans.add(count);
        // }

        // return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for(int i = 0 ; i < m ;i++) {
            puzzles[i] = scn.next();
        }
        ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
        for(int i=0;i<ans.size();i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
    
}
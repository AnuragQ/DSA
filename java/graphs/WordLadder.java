import java.util.*;

class WordLadder {
    class Pair{
        String word;
        int tcount;
        Pair(String word,int tcount){
            this.word=word;
            this.tcount=tcount;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String i:wordList){
            set.add(i);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair rem=q.remove();
            if(rem.word.equals(endWord)){
                return rem.tcount;
            }
            for(int i =0;i<rem.word.length();i++){
                for(int j=0;j<26;j++){
                    char ch='a';
                    ch+=j;
                    if(rem.word.charAt(i)!=ch){
                        String newWord=rem.word.substring(0,i)+ch+rem.word.substring(i+1);
                        if(set.contains(newWord)){
                            q.add(new Pair(newWord,rem.tcount+1));
                            set.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
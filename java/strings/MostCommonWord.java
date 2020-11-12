import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        for(int i=0;i<words.length;i++){
            String word=words[i];
            if(!set.contains(word)){
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        String ans="";
        int maxfreq=0;
        for(String i:map.keySet()){
            if(map.get(i)>maxfreq){
                maxfreq=map.get(i);
                ans=i;
            }
        }
        return ans;
    }
}
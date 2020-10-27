import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>(); 
        for(int i=0;i<strs.length;i++){
            
            String count=getCount( strs[i]);
            if(!map.containsKey(count))
                map.put(count,new ArrayList<>());
            map.get(count).add(strs[i]);
            
        }
        List<List<String>> ans=new ArrayList<>();
        for(String i:map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }
    public String getCount(String str){
        int[] freq=new int[26];
        for(int i=0;i<str.length();i++){
            
            freq[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<26;i++){
            sb.append('#'+freq[i]);
        }
        return sb.toString();
    }
}
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<Integer,ArrayList<String>> map=new HashMap<>(); 
//         for(int i=0;i<strs.length;i++){
//             int mask=getMask( strs[i]);
//             if(!map.containsKey(mask))
//                 map.put(mask,new ArrayList<>());
//             map.get(mask).add(strs[i]);
            
//         }
//         List<List<String>> ans=new ArrayList<>();
//         for(int i:map.keySet()){
//             ans.add(map.get(i));
//         }
//         return ans;
//     }
//     public int getMask(String str){
//         int mask=0;
//         for(int i=0;i<str.length();i++){
//             char ch=str.charAt(i);
//             mask|=1<<(ch-'a');
//         }
//         return mask;
//     }
// }
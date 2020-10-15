import java.util.HashMap;

class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> hm=new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
        }
        int matchCount=0;
        int i=-1;
        int j=-1;
        int bi=-1;
        int bj=-1;
        HashMap<Character,Integer> curhm=new HashMap<>();
        while( i<s.length() || j<s.length()){
            if(matchCount<hm.size() && j<s.length()-1){
                j++;
                char inc=s.charAt(j);
                curhm.put(inc,curhm.getOrDefault(inc,0)+1);
                if(curhm.get(inc).equals(hm.get(inc))){
                    matchCount++;
                }
            }else if(matchCount==hm.size() && i<s.length()-1){
                i++;
                char exc=s.charAt(i);
                curhm.put(exc,curhm.get(exc)-1);
                if(hm.containsKey(exc) && curhm.get(exc)<hm.get(exc)){
                    matchCount--;
                }
                
            }else{
                break;
            }
            if(matchCount==hm.size()){
                if((bj==-1 && bi==-1) || j-i<bj-bi){
                    bj=j;
                    bi=i;
                }
            }
            
            
        }
        return s.substring(bi+1,bj+1);
    }
}
// https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;
 class Pair{
    public Pair(Character ch, Integer freq) {
        this.ch=ch;
        this.freq=freq;
    }

    char ch;
    int freq;
}
class RearrangeKDistApart {
    
    public static void main(String[] args) {
        String str="aaab";
        int k=1;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<str.length();i++){
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->{
            if(x.freq==y.freq){
                return x.ch-y.ch;
            }else{
                return y.freq-x.freq;
            }
        });
        for(Character i:hm.keySet()){
            pq.add(new Pair(i,hm.get(i)));
        }
        boolean cando=true;

        Character[] ans=new Character[str.length()];
        while(!pq.isEmpty()){
            Pair rem=pq.remove();
            int freq=rem.freq;
            char ch=rem.ch;
            for(int i=0;i<str.length();i++){
                if(ans[i]==null){
                    ans[i]=ch;
                    i+=k-1;
                    freq--;
                }else{
                    continue;
                }
                
                if(freq==0){
                    break;
                }
                
            }

            if(freq!=0){
                System.out.println("Can't do it man");
                cando=false;
                break;
            }

        }
        if(cando){
            System.out.println();
            for(int i=0;i<ans.length;i++){
                System.out.print(ans[i]);
            }
            System.out.println();

        }


    }
}
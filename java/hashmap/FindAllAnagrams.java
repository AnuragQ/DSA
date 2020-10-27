import java.util.*;

public class FindAllAnagrams {
    static boolean compare(HashMap<Character,Integer> smap,HashMap<Character,Integer> pmap){
        for(Character p:pmap.keySet()){
            if(pmap.get(p)!=smap.get(p)){
                return false;
            }
        }
        return true;
    }
	public static void findAnagrams(String s, String p) {
        // write your code here
        HashMap<Character,Integer> pmap =new HashMap<>();
        HashMap<Character,Integer> smap =new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<p.length();i++){
            char ch=s.charAt(i);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            
        }
        // int size=p.length();
        int i=0;
        int j=p.length();
        ArrayList<Integer> ans=new ArrayList<>();
        while(j<s.length()){
            if(compare(smap,pmap)){
                ans.add(i);
            }
            char rel=s.charAt(i);
            char acq=s.charAt(j);
            i++;
            j++;
            smap.put(acq,smap.getOrDefault(acq,0)+1);
            if(smap.get(rel)==1){
                smap.remove(rel);
            }else{
                smap.put(rel,smap.get(rel)-1);
            }


        }
        if(compare(smap,pmap)){
            ans.add(i);
        }
        
        System.out.println(ans.size());
        for( i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
        
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}

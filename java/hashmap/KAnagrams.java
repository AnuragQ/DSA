import java.util.*;

public class KAnagrams {
	public static boolean areKAnagrams(String str1, String str2, int k) {
		// write your code here
        if(str1.length()!=str2.length()){
            return false;
        }
        if(str1.length()<=k){
            return true;
        }
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<str2.length();i++){
            map.put(str1.charAt(i),map.getOrDefault(str1.charAt(i),0)+1);
            map.put(str2.charAt(i),map.getOrDefault(str2.charAt(i),0)-1);
        }
        int ans=0;
        for(Character ch:map.keySet()){
            ans+=map.get(ch)>0?map.get(ch):0;
        }
        return k>=ans;
		
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}

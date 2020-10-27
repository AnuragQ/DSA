import java.util.*;

public class IsIsomorphic {

	public static boolean isIsomorphic(String s, String t) {
	    HashMap<Character,Character> map=new HashMap<>();
	    HashSet<Character> used=new HashSet<>();
	    for(int i=0;i<s.length();i++){
	        char ch1=s.charAt(i);
	        char ch2=t.charAt(i);
	        if(map.containsKey(ch1) ){
	            if(map.get(ch1)!=ch2)
	                return false;
	        } else{
	            if(used.contains(ch2))
    	            return false;
    	        else{
    	            map.put(ch1,ch2);
    	            used.add(ch2);
    	        }
	        }
	    }
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

}

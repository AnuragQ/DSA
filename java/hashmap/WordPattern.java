import java.util.*;

public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character,String> map=new HashMap<>();
	    HashSet<String> used=new HashSet<>();
	    String[] strArr=str.split(" ");
	    for(int i=0;i<pattern.length();i++){
	        char ch1=pattern.charAt(i);
	        String ch2=strArr[i];
	        if(map.containsKey(ch1) ){
	            if(!map.get(ch1).equals(ch2))
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
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

}

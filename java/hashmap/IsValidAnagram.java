import java.util.*;

public class IsValidAnagram {
	
	public static boolean solution(String str1, String str2){
		HashMap<Character,Integer> map=new HashMap<>();
		
		for(int i=0;i<str1.length();++i){
		    char ch=str1.charAt(i);
		    map.put(ch,map.getOrDefault(ch,0)+1);
		}
		for(int i=0;i<str2.length();++i){
		    char ch=str2.charAt(i);
		    if(!map.containsKey(ch)){
		        return false;
		    }
		    if(map.get(ch)==1){
		        map.remove(ch);
		    }else{
		        map.put(ch,map.get(ch)-1);
		    }
		}
		return map.size()==0;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}

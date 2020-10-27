
import java.util.*;
import java.util.HashMap f;

public class LongestSubStringWithAtmostKUnique {

	public static int solution(String str, int k) {
		int ans=0;
		int i=-1,j=-1;
		HashMap<Character,Integer> map=new HashMap<>();
		while(true){
		    boolean f1=false,f2=false;
		    while(i<str.length()-1){
		        f1=true;
		        i++;
		        char ch=str.charAt(i);
		        map.put(ch,map.getOrDefault(ch,0)+1);
		        if(map.size()<=k){
		            ans=Math.max(ans,i-j);
		        }else{ 
		            break;
		        }
		    }
		    
		    while(j<i){
		        j++;
		        f2=true;
		        char ch=str.charAt(j);
		        if(map.get(ch)==1){
		            map.remove(ch);
		        }else{
		            map.put(ch,map.get(ch)-1);
		        }
		        if(map.size()==k){
		            ans=Math.max(ans,i-j);
		            break;
		        }
		    }
		    
		    if(!f1&& !f2){
		        break;
		    }
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}

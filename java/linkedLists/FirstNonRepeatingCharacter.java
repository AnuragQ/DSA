/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0#ExpectOP
// https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
import java.util.*;
import java.lang.*;
import java.io.*;



// one optimization is to use dll(candidate queue) and an address array and delete nodes from dll as soon as their frequency increases from 1 to 2 
class GFG {
	public static void main (String[] args)throws IOException {
		//code  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    String[] arr=br.readLine().split(" ");
		    
		    
		    int[] frequency=new int[26];
		    ArrayDeque<Character> q=new ArrayDeque<>();
		    char first='1';
		    for(int i=0;i<n;i++){
		        char ch=arr[i].charAt(0);
		        if(frequency[ch-'a']==0){
		            q.add(ch);
		            frequency[ch-'a']++;
		            if(first=='1'){
		                first=ch;
		            }
		        }else{
		            frequency[ch-'a']++;
		            if(ch==first){
    		            while(!q.isEmpty() ){
    		                char rem=q.remove();
    		                if(frequency[rem-'a']==1){
    		                    first=rem;
    		                    q.add(rem);
    		                    break;
    		                }
    		            }
    		            if(q.isEmpty()){
    		                first='1';
    		            }
		            }
		            
		        }
		        if(first=='1'){
		            System.out.print("-1 ");
		        }else{
		            System.out.print(first+" ");
		        }
		    }
		    System.out.println();
		    
		    
		}
// 		while(t-->0){
// 		    int n=Integer.parseInt(br.readLine());
// 		    String[] arr=br.readLine().split(" ");
		    
		    
// 		    int[] frequency=new int[26];
// 		    ArrayDeque<Character> q=new ArrayDeque<>();
		    
// 		    String first="1";
// 		    for(int i=0;i<n;i++){
// 		        char ch=arr[i].charAt(0);
		        
// 		        if(frequency[ch-'a']==0){
// 		            q.add(ch);
// 		            frequency[ch-'a']++;
// 		            if("-1".equals(first)){
// 		                first=Character.toString(ch);
// 		            }
		            
// 		        }else{
// 		            frequency[ch-'a']++;
// 		            if(ch==first.charAt(0)){
    		                
    		            
//     		            while(!q.isEmpty() ){
//     		                char rem=q.remove();
    		                
//     		                if(frequency[rem-'a']==1){
//     		                    first=Character.toString(rem);
//     		                    q.add(rem);
//     		                    break;
//     		                }
//     		            }
//     		            if(q.isEmpty()){
//     		                first="-1";
//     		            }
// 		            }
		            
// 		        }
// 		        System.out.print(first+" ");
// 		    }
// 		    System.out.println();
		    
		    
// 		}
	}
}









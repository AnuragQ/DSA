import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
public class naveen_circular_sum {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] inp=br.readLine().split(" ");
            int[] arr = new int[n];
            for (int x = 0; x < n; x++) {
                arr[x] = Integer.parseInt(inp[x]);
            }
            
            // array sum
            int sum = 0;
            for(int i = 0 ; i < n ; i++){
                sum += arr[i];
            }        
            // System.out.println(sum);
            int cs = arr[0];
            int os = arr[0];
            
            for(int i = 1 ; i < n ; i++){
                int num = arr[i];
                int forCheck = cs+num; 
                
                // updating current sum
                if(forCheck > num){
                    cs = forCheck;
                }else{
                    cs = num;
                }
                
                // updating overall sum
                if(cs > os){
                    os = cs;
                }
            } 
            int temp=os;
    
    
            // array Flip
            for(int i = 0 ; i < n ; i++){
                int num = arr[i];
                if(num > 0){
                    arr[i] = -num;
                }else if(num < 0){
                    arr[i] = Math.abs(num);
                }else{
                    arr[i] = num;
                }
            }
            
            // kadane algorithim
             cs = arr[0];
             os = arr[0];
            for(int i = 1 ; i < n ; i++){
                int num = arr[i];
                int forCheck = cs+num; 
                
                // updating current sum
                if(forCheck > num){
                    cs = forCheck;
                }else{
                    cs = num;
                }
                
                // updating overall sum
                if(cs > os){
                    os = cs;
                }
            }
            
            // System.out.println(os);
            int ans=Math.max(temp,os+sum);
            if(ans<=0){
                System.out.println( -1);
            }else{
                System.out.println(ans);
            }
		}
	}
	

}
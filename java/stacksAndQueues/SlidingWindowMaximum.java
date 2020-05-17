import java.io.*;
import java.util.*;

public class SlidingWindowMaximum{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
    int[] nge=new int [n];
    Stack<Integer> st = new Stack<>();
    
    for(int i =n-1 ; i>=0;i--){
        while(st.size()>0 && a[st.peek()]<a[i]){
            st.pop();
        } 
        if(st.isEmpty()){
            nge[i]=i;
        }
        else{
            nge[i]=st.peek();
        }
        st.push(i);
    }
    for (int i=0;i<=n-k;i++){
        // System.out.print(nge[i]+" ");
        
        int tempidx=i;
        while(tempidx<i+k){
            if(tempidx==nge[tempidx] || tempidx>=i+k || nge[tempidx]>=i+k)
            break;
            
            tempidx=nge[tempidx];
            
        }
        System.out.println(a[tempidx]);
        
    }
    
    // code
 }
}
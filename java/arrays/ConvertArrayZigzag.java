package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertArrayZigzag {
    public static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
	public static void main (String[] args) throws NumberFormatException, IOException{
		//code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String[] str=br.readLine().split(" ");
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
        
            if(arr.length>1){
                for(int i=1; i<arr.length;i+=2){
                    if(arr[i]<arr[i-1]){
                        swap(i,i-1,arr);
                        
                    }
                    if(i+1<arr.length && arr[i]<arr[i+1]){
                        swap(i,i+1,arr);
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
                System.out.println();

        }
	}   
}
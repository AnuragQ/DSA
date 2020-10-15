import java.util.ArrayDeque;

import java.util.Scanner;

public class PrintAllLongestIncreasingSubsequences{
        public static class Pair{
            int i;
            int val;
            int l;
            String psf;
            public Pair(int i,int val,int l,String psf){
                this.i=i;
                this.val=val;
                this.l=l;
                this.psf=psf;
            }
            
        }
    public static void solution(int []arr){
        // write your code here
        int n=arr.length;
        int[] lis=new int[n];
        
        int omax=0;
        int omaxi=0;
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    max=Math.max(max,lis[j]);
                }
            }
            lis[i]=max+1;
            if(lis[i]>omax){
                omax=lis[i];
                omaxi=i;
            }
        }
        System.out.println(omax);
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(omaxi,arr[omaxi],omax,arr[omaxi]+""));
        while(q.size()>0){
            Pair rem=q.remove();

            if(rem.l==1){
                System.out.println(rem.psf);
            }
            for(int i=rem.i-1;i>=0;i--){
                if(lis[i]==rem.l-1){
                    if(arr[i]<rem.val)
                        q.add(new Pair(i,arr[i],rem.l-1,arr[i]+" -> "+rem.psf));
                }
            }
        }
        
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
    
}






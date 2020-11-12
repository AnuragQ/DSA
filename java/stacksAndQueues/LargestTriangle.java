import java.util.*;

class LargestTriangle {
    public int largestHistogram(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] nsl=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        st=new Stack<>();
        int[] nsr=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nsr[i]=arr.length;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]*(nsr[i]-nsl[i]-1));
        }
        // System.out.println(max);
        return max;
    }
    public int solve(int[][] matrix) {
        int[] hist=new int[matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    hist[j]++;
                }else{
                    hist[j]=0;
                }
            }
            // for(int k:hist){
            //     System.out.print(k+"  ");
            // }
            // System.out.println();
            ans=Math.max(ans,largestHistogram(hist));
        }
        return ans;
    }
}
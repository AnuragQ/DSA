
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution_3 {
    

    /* package whatever //do not write package name here */
    
    
    public static int[] one_d(BufferedReader br) throws IOException{
        String[] inp = br.readLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }   
    static int height=1000000000;
    static int width=1000000000;
    
    public static String solution(BufferedReader br) throws IOException{
        String str=br.readLine();
        Integer[] pos={0,0};
        Stack<Integer[]> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            switch (ch) {
                case 'N':
                    pos[0]--;
                    pos[0]+=height;
                    pos[0]%=height;
                    break;
                case 'S':
                    pos[0]++;
                    
                    pos[0]%=height;
                    break;
                case 'E':
                    pos[1]++;
                    pos[1]%=height;
                    break;
                case 'W':
                    pos[1]--;
                    pos[1]+=height;
                    pos[1]%=height;
                    break;
                case '(':
                    pos[0]=0;
                    pos[1]=0;
                    break;
                case ')'  :
                    Integer[] prevPos=st.pop();
                    pos[0]=prevPos[0]+(int)(((long)pos[0]*(long)prevPos[2])%height);
                    pos[1]=prevPos[1]+(int)(((long)pos[1]*(long)prevPos[2])%height);
                   
                    pos[0]%=height;
                    pos[1]%=width;
                    
                    break;
                default:
                    Integer[] prev={pos[0],pos[1],ch-'0'};
                    st.push(prev);
                    break;
            }
        }
        pos[0]++;
        pos[1]++;
        return pos[1]+" "+pos[0];
    }

    

    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            count++;            
            String ans=solution(br);
            System.out.println("Case #"+count+": "+ans);

        }
        

        br.close();

    }
}

import java.util.*;
import java.io.*;
import java.text.*;


public class Solution_2 {
    class cord{
        int x;
        int y;
        cord(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    void solve(int TC) throws Exception{
        long ans=0;
        int n=Integer.parseInt(nln());
        cord[] arr=new cord[n];
        for(int i=0;i<n;i++){
            int[] inp=one_d();
            arr[i]=new cord(inp[0],inp[1]);
        }
        Arrays.sort(arr,(x,y)->x.y-y.y);
        int besty=arr[((arr.length-1)/2)].y;
        Arrays.sort(arr,(x,y)->x.x-y.x);
        // 1,2,3
        int bestx=arr[((arr.length-1)/2)].x;
        
        for(int i=0, sp=bestx-(arr.length-1)/2;i<arr.length;i++,sp++){
            ans+=Math.abs(arr[i].x-sp)+Math.abs(arr[i].y-besty);
        }
        pn("Case #"+TC+": "+ans);
    }

    final long IINF = (long)2e18;
    final int INF = (int)1e9+2;

    FastReader in;PrintWriter out;
    
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T=ni();
        for (int t = 1; t <= T; t++) solve(t);
        out.flush();
        out.close();
    }
    public static void main(String[] args) throws Exception{
        new Solution_2().run();
    }

   public int[] one_d() throws Exception{
        String[] inp = nln().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }
    
    
    int digit(long s){int ans = 0;while(s>0){s/=10;ans++;}return ans;}
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception{
            String str;
            try{
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}
import java.util.*;
import java.io.*;
import java.text.*;

// references/credits: @taran_1407 (linkedin.com/in/taran-1407)
// edited by: @anuragq (linkedin.com/in/anuragq)


 class Solution {
    
    void solve(int TC) throws Exception{
        int ans=0;
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
        new Solution().run();
    }

   public int[] one_d(BufferedReader br) throws Exception{
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
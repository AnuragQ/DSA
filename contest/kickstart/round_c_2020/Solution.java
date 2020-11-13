import java.util.*;

import java.io.*;

public class Solution {

    void solve(int TC) throws Exception {
        String ans = "";
        int[] params = one_d();
        int row = params[0];
        int col = params[1];
        String[] arr = new String[row];
        for (int i = 0; i < row; i++) {
            arr[i] = nln();
        }
        boolean isValid = true;
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> alone = new HashSet<>();
        for (int i = 0; i < row && isValid; i++) {
            for (int j = 0; j < col && isValid; j++) {
                char dep = arr[i].charAt(j);
                set.add(dep);
                if (alone.contains(dep)) {
                    isValid = false;
                    break;
                } else if ((i - 1 >= 0 && arr[i - 1].charAt(j) == dep) 
                        || (j - 1 >= 0 && arr[i].charAt(j - 1) == dep)
                        || (i + 1 < row && arr[i + 1].charAt(j) == dep)
                        || (j + 1 < col && arr[i].charAt(j + 1) == dep)) {
                } else {
                    alone.add(dep);

                }
                if (!map.containsKey(dep)) {
                    map.put(dep, new HashSet<>());
                }

                if (i < row - 1) {
                    char ch = arr[i + 1].charAt(j);
                    if (!map.containsKey(ch)) {
                        map.put(ch, new HashSet<>());
                    }
                    if (dep != ch) {

                        if (!map.get(ch).contains(dep)) {
                            map.get(ch).add(dep);
                            indegree[dep - 'A']++;
                        }
                    }
                }
                // else {
                // // if (!map.containsKey('g')) {
                // // map.put('g', new HashSet<>());
                // // }
                // // map.get('g').add(dep);
                // if (!map.containsKey(dep)) {
                // map.put(dep, new HashSet<>());
                // }
                // }
            }
        }
        if (isValid) {
            ArrayDeque<Character> zero = new ArrayDeque<>();

            for (Character ch : set) {
                if (indegree[ch - 'A'] == 0) {
                    zero.add(ch);

                }
            }
            while (!zero.isEmpty()) {
                Character rem = zero.remove();
                ans += rem;

                for (char ch : map.get(rem)) {
                    indegree[ch - 'A']--;
                    if (indegree[ch - 'A'] == 0) {
                        zero.add(ch);
                    }
                }
            }
            pn("Case #" + TC + ": " + (ans.length() != set.size() ? "-1" : ans));
        } else {
            pn("Case #" + TC + ": " + "-1");
        }

    }

    final long IINF = (long) 2e18;
    final int INF = (int) 1e9 + 2;

    FastReader in;
    PrintWriter out;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = ni();
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public int[] one_d() throws Exception {
        String[] inp = nln().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        return arr;
    }

    int digit(long s) {
        int ans = 0;
        while (s > 0) {
            s /= 10;
            ans++;
        }
        return ans;
    }

    long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    double nd() throws Exception {
        return Double.parseDouble(in.next());
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception {
            String str;
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */
public class template_khomkharnikun8 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "khokharnikunj8", 1 << 27);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            StableWall solver = new StableWall();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class StableWall {
        int[][] G;
        int edges;
        boolean[][] edge;

        public static int[][] packGraphdirected(int[] from, int[] to, int n, int m) {
            int[][] g = new int[n + 1][];
            int[] p = new int[n + 1];
            for (int i = 0; i < m; i++) p[from[i]]++;
            for (int i = 0; i <= n; i++) g[i] = new int[p[i]];
            for (int i = 0; i < m; i++) g[from[i]][--p[from[i]]] = to[i];
            return g;
        }

        public void solve(int testNumber, FastInput in, FastOutput out) {
            out.append("Case #" + testNumber + ": ");
            int n = 26;
            int r = in.readInt();
            int c = in.readInt();
            char[][] ar = new char[r][];
            edge = new boolean[26][26];
            for (int i = 0; i < r; i++) ar[i] = in.readString().toCharArray();
            boolean[] present = new boolean[26];
            for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) present[ar[i][j] - 'A'] = true;
            for (int i = 0; i < r - 1; i++) {
                for (int j = 0; j < c; j++) {
                    if (ar[i][j] != ar[i + 1][j]) {
                        edge[ar[i][j] - 'A'][ar[i + 1][j] - 'A'] = true;
                    }
                }
            }
            edges = 0;
            for (int i = 0; i < 26; i++) for (int j = 0; j < 26; j++) if (edge[i][j]) edges++;
            int[] from = new int[edges];
            int[] to = new int[edges];
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < 26; j++)
                    if (edge[i][j]) {
                        from[edges - 1] = i + 1;
                        to[edges - 1] = j + 1;
                        edges--;
                    }
            G = packGraphdirected(from, to, 26, from.length);
            int[] order = sortTopologically(G);
            if (order == null) {
                out.println("-1");
                return;
            } else {
                for (int i = 26; i >= 1; i--) {
                    if (present[order[i] - 1]) {
                        out.append((char) ('A' + order[i] - 1));
                    }
                }
                out.println();
            }
        }

        public int[] sortTopologically(int[][] G) {
            //1 based. return first element 0.
            // 0 based, fine.
            int[] result = new int[G.length];
            int[] in_degree = new int[G.length];
            for (int i = 0; i < G.length; i++) for (int j : G[i]) in_degree[j]++;
            int q = 0;
            for (int i = 0; i < G.length; i++) if (in_degree[i] == 0) result[q++] = i;
            for (int i = 0; i < q; i++) {
                for (int j : G[result[i]]) {
                    if (--in_degree[j] == 0) result[q++] = j;
                }
            }
            for (int i = 0; i < G.length; i++) if (in_degree[i] > 0) return null;
            return result;
        }

    }

    static class FastInput {
        private final InputStream is;
        private final StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private final byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public String next() {
            return readString();
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

        public String readString(StringBuilder builder) {
            skipBlank();

            while (next > 32) {
                builder.append((char) next);
                next = read();
            }

            return builder.toString();
        }

        public String readString() {
            defaultStringBuf.setLength(0);
            return readString(defaultStringBuf);
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private final Writer os;
        private final StringBuilder cache = new StringBuilder(1 << 20);

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(String c) {
            return append(c).println();
        }

        public FastOutput println() {
            cache.append(System.lineSeparator());
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
        }

    }
}

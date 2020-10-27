import java.io.*;
import java.util.*;

public class LargestAreaHistogram {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int ans=largestAreaHistogram(a);
        System.out.print(ans);





        // code
    }
static int largestAreaHistogram(int[] a){
    int n=a.length;
    int[] rb = new int[n];
    rb[n - 1] = n;
    Stack < Integer > st = new Stack < Integer > ();
    st.push(n-1);
    for (int i = n - 2; i >= 0; i--) {
        while (st.size() > 0 && a[i] <= a[st.peek()]) {
            st.pop();
        }
        if (st.size() == 0) {
            rb[i] = n;

        } else {
            rb[i] = st.peek();
        }
        st.push(i);
    }
    int[] lb = new int[n];
    lb[n - 1] = -1;
    st = new Stack < Integer > ();
    st.push(0);
    for (int i = 1; i < n; i++) {
        while (st.size() > 0 && a[i] <= a[st.peek()]) {
            st.pop();
        }
        if (st.size() == 0) {
            lb[i] = -1;

        } else {
            lb[i] = st.peek();
        }
        st.push(i);
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        int area = (rb[i] - lb[i] - 1) * a[i];
        ans = Math.max(ans, area);
    }
    return ans;
}
}












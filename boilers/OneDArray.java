// import java.util.*;
// import java.lang.*;
import java.io.*;

public class OneDArray {

	/* package whatever //do not write package name here */

	public static void main(String[] args) throws IOException {
		// code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt((br.readLine()));
			String[] inp = br.readLine().split(" ");
			int[] arr = new int[inp.length];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inp[i]);
			}

		}

		br.close();

	}
}

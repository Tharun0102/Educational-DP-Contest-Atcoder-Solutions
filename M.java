
// Candies

import java.io.*;
import java.util.*;

public class M {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        /*
         * count(i,k)=> for(int j=0;j<=i;j++){ if(j>k) break; ans+=count(i+1,k-j); }
         * 
         */
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long[][] count = new long[n + 1][k + 1];
        long[] sum = new long[k + 1];
        int mod = (int) 1e9 + 7;
        count[0][0] = 1;
        sum[0] = 1;
        for (int j = 1; j <= k; j++) {
            sum[j] = sum[j - 1] + count[0][j];
        }
        for (int i = 1; i <= n; i++) {
            sum[0] = count[i - 1][0];
            for (int j = 1; j <= k; j++) {
                sum[j] = (count[i - 1][j] + sum[j - 1]) % mod;
            }
            for (int j = 0; j <= k; j++) {
                count[i][j] = sum[j];
                if (j > arr[i - 1]) {
                    int rem = j - arr[i - 1] - 1;
                    count[i][j] = (count[i][j] - sum[rem] + mod) % mod;
                }
            }
        }
        out.println(count[n][k]);
        out.close();

    }

    private static int fun(int[] arr, int i, int k, int[][] count) {
        if (k < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (i == arr.length) {
            return 0;
        }
        if (count[i][k] != -1) {
            return count[i][k];
        }

        int ans = 0, mod = (int) 1e9 + 7;
        for (int j = 0; j <= arr[i]; j++) {
            if (j > k) {
                break;
            }
            ans = (ans + fun(arr, i + 1, k - j, count)) % mod;
        }
        return count[i][k] = ans;
    }

    static class Reader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public boolean hasNext() {
            String next = null;
            try {
                next = br.readLine();
            } catch (Exception e) {
            }
            if (next == null) {
                return false;
            }
            st = new StringTokenizer(next);
            return true;
        }
    }
}

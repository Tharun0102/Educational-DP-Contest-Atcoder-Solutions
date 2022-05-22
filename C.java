
// Vacation

import java.io.*;
import java.util.*;

public class C {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][3];

        // Fill dp array with max val
        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = a[i] + Math.max(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = b[i] + Math.max(dp[i - 1][0], dp[i - 1][2]);
                } else {
                    dp[i][j] = c[i] + Math.max(dp[i - 1][1], dp[i - 1][0]);
                }
            }
        }
        int res = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        out.println(res);

        out.close();

    }

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return pow(a * a, b / 2);
        } else {
            return a * pow(a * a, b / 2);
        }
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

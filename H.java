
// Grid 1

import java.io.*;
import java.util.*;

public class H {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int H = sc.nextInt(), W = sc.nextInt();
        int[][] arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            String row = sc.next();
            for (int j = 0; j < W; j++)
                arr[i][j] = (row.charAt(j) == '#') ? 1 : 0;
        }
        int mod = (int) 1e9 + 7;

        int[][] dp = new int[H][W];

        // base cases:
        dp[H - 1][W - 1] = 1;
        // last row (base case)
        for (int j = W - 2; j >= 0; j--) {
            dp[H - 1][j] = (arr[H - 1][j] == 1) ? 0 : dp[H - 1][j + 1];
        }
        // last column
        for (int i = H - 2; i >= 0; i--) {
            dp[i][W - 1] = (arr[i][W - 1] == 1) ? 0 : dp[i + 1][W - 1];
        }

        for (int i = H - 2; i >= 0; i--) {
            for (int j = W - 2; j >= 0; j--) {
                dp[i][j] = 0;
                if (arr[i][j] == 0) {
                    dp[i][j] = (dp[i][j + 1] + dp[i + 1][j]) % mod;
                }
            }
        }
        out.println(dp[0][0]);

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

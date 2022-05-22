
// Deque

import java.io.*;
import java.util.*;

public class L {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long sum = 0;
        for (long e : arr) {
            sum += e;
        }
        long Taros = play(arr, 0, n - 1, dp);
        long Jiros = sum - Taros;
        out.println(Taros - Jiros);

        out.close();

    }

    private static long play(long[] arr, int i, int j, long[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return arr[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long sa1 = arr[i] + Math.min(play(arr, i + 2, j, dp), play(arr, i + 1, j - 1, dp));
        long sa2 = arr[j] + Math.min(play(arr, i, j - 2, dp), play(arr, i + 1, j - 1, dp));
        return dp[i][j] = Math.max(sa1, sa2);
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

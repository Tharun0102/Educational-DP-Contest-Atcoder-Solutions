
// stones 

import java.io.*;
import java.util.*;

public class K {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int res = fun(arr, n, k, 0, dp);
        if (res == 0)
            out.println("First");
        else
            out.println("Second");
        // for(int i=1;i<=k;i++){
        // out.println(dp[i][0]+" "+dp[i][1]);
        // }
        out.close();

    }

    private static int fun(int[] arr, int n, int k, int turn, int[][] dp) {
        if (dp[k][turn] != -1)
            return dp[k][turn];
        for (int i = 1; i <= n; i++) {
            if (k >= arr[i]) {
                int curr = fun(arr, n, k - arr[i], 1 - turn, dp);
                dp[k - arr[i]][1 - turn] = curr;
                if (curr == turn) {
                    return turn;
                }
            }
        }
        return dp[k][turn] = 1 - turn;
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

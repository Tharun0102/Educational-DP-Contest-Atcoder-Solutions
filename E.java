
// Knapsack 2 
/*
    [1-N] => subset of items such that sum of the values=V with min. sum of weights possible.
    choose greatest V such that dp(N,V)<=W 
    dp(i,v) ={
        -> dp(i-1,v);
        -> dp(i-1,v-val[i])+w[i];
    }
    //base cases:
    dp(1,x)=w[1] if(x==val[1]) ;
                else dp(1,x)=Max_val;
    dp(1,0)=0;
*/
import java.io.*;
import java.util.*;

public class E {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt(), W = sc.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int maxval = 100000;
        long[][] dp = new long[n + 1][maxval + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= maxval; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[1][0] = 0;
        for (int j = 1; j <= maxval; j++) {
            dp[1][j] = (v[1] == j) ? w[1] : Integer.MAX_VALUE;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= maxval; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // dont take
                dp[i][j] = dp[i - 1][j];
                // take
                if (j >= v[i]) {
                    if (dp[i - 1][j - v[i]] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], w[i] + dp[i - 1][j - v[i]]);
                }
            }
        }
        int res = 0;
        for (int ans = maxval; ans >= 0; ans--) {
            if (dp[n][ans] <= W) {
                res = ans;
                break;
            }
        }
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

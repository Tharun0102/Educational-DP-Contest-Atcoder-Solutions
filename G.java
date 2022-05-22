
// Longest Path

import java.io.*;
import java.util.*;

public class G {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int tt = 0; tt < m; tt++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int curr = fun(adj, i, dp);
            res = Math.max(res, curr);
        }
        out.println(res);
        out.close();

    }

    private static int fun(ArrayList<Integer>[] adj, int vertex, int[] dp) {
        // base cases
        if (adj[vertex].size() == 0) {
            return 0;
        }
        if (dp[vertex] != -1) {
            return dp[vertex];
        }
        int ans = 0;
        for (int children : adj[vertex]) {
            ans = Math.max(ans, 1 + fun(adj, children, dp));
        }
        return dp[vertex] = ans;
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


// Frog 1

/*
  -> Memoization approach

  public static void main(String args[])throws IOException
    {
        Reader sc=new Reader();
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++) arr[i]=sc.nextInt();

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        out.println(rec(n,arr,dp));
        
    	out.close();
 
    }
    private static int rec(int n,int[] arr,int[] dp){
        if(n==1){
            return 0;
        }
        if(n<=0){
            return 987654321;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        // n-1
        int op1=rec(n-1,arr,dp)+Math.abs(arr[n]-arr[n-1]);
        // n-2;
        int op2=rec(n-2,arr,dp)+Math.abs(arr[n]-arr[n-2]);
        return dp[n]=Math.min(op1,op2);
    }
*/

import java.io.*;
import java.util.*;

public class A {

    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 987654321;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + Math.abs(arr[i] - arr[i - 2]), dp[i - 1] + Math.abs(arr[i] - arr[i - 1]));
        }
        out.println(dp[n]);

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

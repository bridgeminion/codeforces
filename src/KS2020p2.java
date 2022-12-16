//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Solution {
//
//    public static void solve (int n, int k, int[][] val, int p){
//        int[][] prefix = new int[n][k+1];
//        for (int i=0; i < n; i++){
//            for (int j=0; j < k; j++){
//                prefix[i][j+1] = prefix[i][j] + val[i][j];
//            }
//        }
//        int[][] dp = new int[n+1][p+1];
//        for (int i=0; i < n; i++){
//            for (int j=0; j <= p; j++){
//                for (int a=0; a <= Math.min(k, p-j); a++){
//                    dp[i+1][j+a] = Math.max(dp[i+1][j+a], dp[i][j] + prefix[i][a]);
//                }
//            }
//        }
//        System.out.print(dp[n][p]);
//        System.out.println();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for (int i=0; i < t; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken());
//            int k = Integer.parseInt(st.nextToken());
//            int p = Integer.parseInt(st.nextToken());
//            int[][] val = new int[n][k];
//            for (int j=0; j < n; j++){
//                st = new StringTokenizer(br.readLine());
//                for (int a=0; a < k; a++){
//                    val[j][a] = Integer.parseInt(st.nextToken());
//                }
//            }
//            System.out.print("Case #" + (i+1) + ": ");
//            solve (n, k, val, p);
//        }
//    }
//}

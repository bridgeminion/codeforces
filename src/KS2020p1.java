//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Solution {
//
//    public static void solve (int n, int b, int[] arr){
//        Arrays.sort(arr);
//        int counter = 0;
//        int index = 0;
//        while (b >= 0 && index < n){
//            b -= arr[index];
//            index++;
//            counter++;
//        }
//        if (b < 0){
//            counter--;
//        }
//        System.out.print(counter);
//        System.out.println();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for (int i=0; i < t; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int[] arr = new int[n];
//            st = new StringTokenizer(br.readLine());
//            for (int j=0; j < n; j++){
//                arr[j] = Integer.parseInt(st.nextToken());
//            }
//            System.out.print("Case #" + (i+1) + ": ");
//            solve (n, b, arr);
//        }
//    }
//}

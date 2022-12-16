import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C1721D {

    public static int[] readArr (int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static void printArr (int n, int[] arr){
        for (int i=0; i < n-1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[n-1]);
        System.out.println();
    }

    public static boolean on (int x, int bit){
        return (x&(1 << bit)) > 0;
    }

    public static void solve (int[] a, int[] b, int n){
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 0;
        for (int i=29; i >= 0; i--){
            boolean works = true;
            for (int j=0; j < n; j++){
                if (on (a[j], i) == on (b[n-1-j], i)){
                    works = false;
                    break;
                }
            }
            if (works){
                ans += (1L << i);
            }
            else {
                for (int j=0; j < n; j++){
                    if (on (a[j], i)){
                        a[j] -= (1 << i);
                    }
                    if (on (b[j], i)){
                        b[j] -= (1 << i);
                    }
                }
                Arrays.sort(a);
                Arrays.sort(b);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] a = readArr(n, br);
            int[] b = readArr(n, br);
            solve (a, b, n);
        }
    }

}

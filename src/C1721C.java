import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C1721C {

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

    public static void solve (int[] a, int[] b, int n){
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = b[0]-a[0];
        List<Integer> l = new ArrayList<>();
        l.add(b[0]);
        for (int i=1; i < n; i++){
            l.add(b[i]);
            int index = Collections.binarySearch(l, a[i]);
            if (index >= 0){
                min[i] = b[index]-a[i];
            }
            else {
                index = -(index+1);
                min[i] = b[index]-a[i];
            }
        }
        int last_index = 0;
        for (int i=0; i < n-1; i++){
            if (b[i] >= a[i+1]){
                continue;
            }
            for (int j=last_index; j <= i; j++){
                max[j] = b[i]-a[j];
            }
            last_index = i+1;
        }
        for (int j=last_index; j < n; j++){
            max[j] = b[n-1]-a[j];
        }
        printArr(n, min);
        printArr(n, max);
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UTPC2C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[2000];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        a[0] += k;
        for (int i=0; i < 1999; i++){
            a[i+1] += a[i]/4;
            a[i] %= 4;
        }
        int last = 2000;
        for (int i=1999; i >= 0; i--){
            if (a[i] > 0){
                last = i;
                break;
            }
        }
        for (int i=0; i <= last; i++){
            if (i == 0){
                System.out.print(a[i]);
            }
            else {
                System.out.print(" " + a[i]);
            }
        }
    }
}

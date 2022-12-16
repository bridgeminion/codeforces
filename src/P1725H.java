import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1725H {

    public static int[] readArr (int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = readArr(n, br);
        int[] count = new int[2];
        for (int i=0; i < n; i++){
            count[((arr[i]%3)*(arr[i]%3)%3)]++;
        }
        if (count[0] >= n/2){
            System.out.println(2);
            int x = 0;
            for (int i=0; i < n; i++){
                if (arr[i]%3 == 0 && x < n/2){
                    System.out.print('0');
                    x++;
                }
                else {
                    System.out.print('1');
                }
            }
        }
        else {
            System.out.println(0);
            int x = 0;
            for (int i=0; i < n; i++){
                if (arr[i]%3 != 0 && x < n/2){
                    System.out.print('0');
                    x++;
                }
                else {
                    System.out.print('1');
                }
            }
        }
    }

}

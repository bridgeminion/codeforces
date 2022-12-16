import java.io.*;
import java.util.StringTokenizer;

public class FBHacker1 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("p1.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("p1.out"));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            pw.print("Case #" + (i+1) + ": ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] s = new int[n];
            int[] count = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                s[j] = Integer.parseInt(st.nextToken());
                count[s[j]]++;
            }
            if (n > 2*k){
                pw.println("NO");
                continue;
            }
            boolean works = true;
            for (int j=0; j < 101; j++){
                if (count[j] > 2){
                    pw.println("NO");
                    works = false;
                    break;
                }
            }
            if (works){
                pw.println("YES");
            }
        }
        pw.close();
    }
}

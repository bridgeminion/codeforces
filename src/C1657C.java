import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1657C {

    public static void solve (int n, String s){
        int index = 0;
        int operations = 0;
        while (index < n){
            if (s.charAt(index) == '('){
                index += 2;
                operations++;
            }
            else {
                boolean done = true;
                for (int i=index+1; i < n; i++){
                    if (s.charAt(i) == ')'){
                        operations++;
                        done = false;
                        index = i+1;
                        break;
                    }
                }
                if (done){
                    System.out.println(operations + " " + (n-index));
                    return;
                }
            }
        }
        if (index == n){
            System.out.println(operations + " " + 0);
        }
        else {
            System.out.println((operations-1) + " " + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            solve (n, s);
        }
    }

}

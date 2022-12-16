import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EraseandExtend {

    public static String create (int k, String s, int len){
        String ss = s.substring(0, len);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < k/len; i++){
            sb.append(ss);
        }
        int r = k%len;
        sb.append(s.substring(0, r));
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        for (int i=0; i < n-1; i++){
            int begin = 0;
            int next = i+1;
            while (next < n && s.charAt(next) == s.charAt(begin)){
                begin++;
                begin %= (i+1);
                next++;
            }
            if (next == n){
                System.out.println(create (k, s, i+1));
                return;
            }
            else {
                if (s.charAt(begin) < s.charAt(next)){
                    System.out.println(create (k, s, i+1));
                    return;
                }
            }
        }
        System.out.println(create (k, s, n));
    }
}

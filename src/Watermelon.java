import java.io.*;

public class Watermelon {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n%2 == 0 && n != 2){
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }
        pw.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlayoffTournament {

    public static int getLastLow(int k, int[] sums, int cur){
        int index = 0;
        for (int i=1; i < k; i++){
            if (cur > sums[i]){
                index = i;
            }
        }
        int dif = cur - sums[index];
        return sums[index-1] + dif*2 - 1;
    }

    public static int getNext(int k, int[] sums, int cur){
        if (cur == (1 << k)-1){
            return -1;
        }
        int index = 0;
        for (int i=1; i < k; i++){
            if (cur > sums[i]){
                index = i;
            }
        }
        int dif = cur - sums[index];
        return sums[index+1] + (dif+1)/2;
    }

    public static int solve (int k, int[] sums, int[] state, int[] val, int p, char c){
        if (c == '0'){
            state[p] = 0;
            if (p <= (1 << (k-1))){
                val[p] = 1;
            }
            else {
                val[p] = val[getLastLow(k, sums, p)];
            }
        }
        else if (c == '1') {
            state[p] = 1;
            if (p <= (1 << (k-1))){
                val[p] = 1;
            }
            else {
                int low = getLastLow(k, sums, p);
                val[p] = val[low+1];
            }
        }
        else {
            state[p] = 2;
            if (p <= (1 << (k-1))){
                val[p] = 2;
            }
            else {
                int low = getLastLow(k, sums, p);
                val[p] = val[low] + val[low+1];
            }
        }
        int cur = getNext(k, sums, p);
        while (cur != -1){
            int low = getLastLow(k, sums, cur);
            if (state[cur] == 0){
                val[cur] = val[low];
            }
            else if (state[cur] == 1){
                val[cur] = val[low+1];
            }
            else {
                val[cur] = val[low] + val[low+1];
            }
            cur = getNext(k, sums, cur);
        }
        return val[(1 << k)-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = (int)(Math.pow(2, k));
        int[] sums = new int[k];
        for (int i=1; i < k; i++){
            sums[i] = sums[i-1] + (1 << (k-i));
        }
        int[] state = new int[n];
        String s = br.readLine();
        for (int i=1; i < n; i++){
            if (s.charAt(i-1) == '1'){
                state[i] = 1;
            }
            else if (s.charAt(i-1) == '?'){
                state[i] = 2;
            }
        }
        int[] val = new int[n];
        for (int i=1; i <= (1 << (k-1)); i++){
            if (state[i] < 2){
                val[i] = 1;
            }
            else {
                val[i] = 2;
            }
        }
        for (int i=(1 << (k-1))+1; i < n; i++){
            int low = getLastLow(k, sums, i);
            if (state[i] == 0){
                val[i] = val[low];
            }
            else if (state[i] == 1){
                val[i] = val[low+1];
            }
            else {
                val[i] = val[low] + val[low+1];
            }
        }
        int q = Integer.parseInt(br.readLine());
        for (int i=0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            System.out.println(solve (k, sums, state, val, p, c));
        }
    }
}

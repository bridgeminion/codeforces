import java.io.IOException;

public class p1823 {

    public static int findTheWinner(int n, int k) {
        boolean[] out = new boolean[n+1];
        int cur = 0;
        for (int i=0; i < n; i++){
            for (int j=0; j < k; j++){
                cur++;
                if (cur > n){
                    cur -= n;
                }
                while (out[cur]){
                    cur++;
                    if (cur > n){
                        cur -= n;
                    }
                }
            }
            System.out.println("out is " + cur);
            out[cur] = true;
        }
        return cur;
    }

}

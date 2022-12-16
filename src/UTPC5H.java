import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UTPC5H {

    static class Player{
        int a;
        int b;

        public Player(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return a == player.a && b == player.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken())-1;
        }
        st = new StringTokenizer(br.readLine());
        int[] b = new int[n];
        for (int i=0; i < n; i++){
            b[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[] atob = new int[n];
        int[] btoa = new int[n];
        for (int i=0; i < n; i++){
            atob[a[i]] = b[i];
            btoa[b[i]] = a[i];
        }
        Queue<Player> q = new LinkedList<>();
        Set<Player> vis = new HashSet<>();
        q.add(new Player (n-1, atob[n-1]));
        q.add(new Player (btoa[n-1], n-1));
        vis.add(new Player (n-1, atob[n-1]));
        vis.add(new Player (btoa[n-1], n-1));
        while (!q.isEmpty()){
            Player cur = q.remove();
            for (int i=cur.a+1; i < n; i++){
                Player c = new Player (i, atob[i]);
                if (!vis.contains(c)){
                    vis.add(c);
                    q.add(c);
                }
            }
            for (int i=cur.b+1; i < n; i++){
                Player d = new Player (btoa[i], i);
                if (!vis.contains(d)){
                    vis.add(d);
                    q.add(d);
                }
            }
        }
        System.out.println(vis.size());
    }
}

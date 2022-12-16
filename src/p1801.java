import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class p1801 {

    static class B {
        long amt;
        int price;

        public B(long amt, int price) {
            this.amt = amt;
            this.price = price;
        }
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<B> buys = new PriorityQueue<>(new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                return o2.price - o1.price;
            }
        });
        PriorityQueue<B> sells = new PriorityQueue<>(new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                return o1.price - o2.price;
            }
        });
        for (int i=0; i < orders.length; i++){
            int price = orders[i][0];
            long amt = orders[i][1];
            boolean buy = orders[i][2] == 0;
            if (buy){
                while (!sells.isEmpty() && amt > 0){
                    if (sells.peek().price <= price){
                        long used = Math.min(sells.peek().amt, amt);
                        sells.peek().amt -= used;
                        amt -= used;
                        if (sells.peek().amt == 0){
                            sells.poll();
                        }
                    }
                    else {
                        break;
                    }
                }
                if (amt > 0){
                    buys.add(new B (amt, price));
                }
            }
            else {
                while (!buys.isEmpty() && amt > 0){
                    if (buys.peek().price >= price){
                        long used = Math.min(buys.peek().amt, amt);
                        buys.peek().amt -= used;
                        amt -= used;
                        if (buys.peek().amt == 0){
                            buys.poll();
                        }
                    }
                    else {
                        break;
                    }
                }
                if (amt > 0){
                    sells.add(new B (amt, price));
                }
            }
        }
        long ans = 0;
        int mod = 1000000007;
        for (B cur : buys){
            ans += cur.amt;
            ans %= mod;
        }
        for (B cur : sells){
            ans += cur.amt;
            ans %= mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] orders = {{10,5,0},{15,2,1},{25,1,1},{30,4,0}};
//        System.out.println(getNumberOfBacklogOrders(orders));
    }
}

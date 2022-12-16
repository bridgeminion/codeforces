import java.util.TreeSet;

public class p1845 {

    class SeatManager {

        TreeSet<Integer> tset = new TreeSet<>();

        public SeatManager(int n) {
            for (int i=1; i <= n; i++){
                tset.add(i);
            }
        }

        public int reserve() {
            int small = tset.first();
            tset.remove(small);
            return small;
        }

        public void unreserve(int seatNumber) {
            tset.add(seatNumber);
        }
    }
}

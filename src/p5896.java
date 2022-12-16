import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class p5896 {

    class StockPrice {

        TreeMap<Integer, Integer> minmax;
        TreeMap<Integer, Integer> current;
        public StockPrice() {
            minmax = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            current = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
        }

        public void update(int timestamp, int price) {
            if (current.containsKey(timestamp)){
                int old = current.get(timestamp);
                minmax.put(old, minmax.get(old)-1);
                if (minmax.get(old) == 0){
                    minmax.remove(old);
                }
            }
            current.put(timestamp, price);
            minmax.putIfAbsent(price, 0);
            minmax.put(price, minmax.get(price)+1);
        }

        public int current() {
            return current.get(current.lastKey());
        }

        public int maximum() {
            return minmax.lastKey();
        }

        public int minimum() {
            return minmax.firstKey();
        }
    }
}

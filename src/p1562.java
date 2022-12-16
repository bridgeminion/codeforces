import java.util.TreeSet;

public class p1562 {

    // O(n log n) version

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        TreeSet<Integer> tset = new TreeSet();
        tset.add(0);
        tset.add(n+1);
        if (m == n) return n;
        for (int i=n-1; i >= 0; i--){
            int cur = arr[i];
            int high = tset.ceiling(cur);
            int low = tset.floor(cur);
            if ((high-cur == m+1) || (cur-low == m+1)){
                return i;
            }
            tset.add(cur);
        }
        return -1;
    }

    // O(n) version

}

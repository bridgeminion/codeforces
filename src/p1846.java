import java.util.Arrays;

public class p1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int cur = 0;
        for (int i : arr){
            cur = Math.min(cur+1, i);
        }
        return cur;
    }
}

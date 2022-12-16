import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class p5894 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        boolean[] f1 = new boolean[101];
        boolean[] f2 = new boolean[101];
        boolean[] f3 = new boolean[101];
        int[] count = new int[101];
        for (int i : nums1){
            if (!f1[i]){
                f1[i] = true;
                count[i]++;
            }
        }
        for (int i : nums2){
            if (!f2[i]){
                f2[i] = true;
                count[i]++;
            }
        }
        for (int i : nums3){
            if (!f3[i]){
                f3[i] = true;
                count[i]++;
            }
        }
        for (int i=0; i <= 100; i++){
            if (count[i] >= 2){
                ans.add(i);
            }
        }
        return ans;
    }
}

import java.util.HashMap;
import java.util.Map;

public class p5761 {

    class FindSumPairs {

        int[] nums1;
        int[] nums2;

        Map<Integer, Integer> map = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int i : nums2){
                map.putIfAbsent(i, 0);
                map.put(i, map.get(i)+1);
            }
        }

        public void add(int index, int val) {
            map.put(nums2[index], map.get(nums2[index])-1);
            nums2[index] += val;
            map.putIfAbsent(nums2[index], 0);
            map.put(nums2[index], map.get(nums2[index])+1);
        }

        public int count(int tot) {
            int ans = 0;
            for (int i : nums1){
                if (map.containsKey(tot-i)){
                    ans += map.get(tot-i);
                }
            }
            return ans;
        }
    }
}

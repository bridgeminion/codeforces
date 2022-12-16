//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeSet;
//
//public class p300 {
//
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        Map<Integer, Integer> len = new HashMap<>();
//        Map<Integer, Integer> prefix = new HashMap<>();
//        TreeSet<Integer> tset = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        for (int i=0; i < n; i++){
//            Integer less = tset.floor(nums[i]-1);
//            if (less != null){
//                if (len.containsKey(nums[i])){
//
//                }
//            }
//            else {
//                len.put(nums[i], 1);
//                prefix.put(nums[i], 1);
//            }
//            tset.add(nums[i]);
//        }
//    }
//
//}

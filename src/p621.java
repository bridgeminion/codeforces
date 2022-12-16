import java.util.*;

public class p621 {

//    static class Letter {
//        char c;
//        int count;
//
//        public Letter (char c, int count){
//            this.c = c;
//            this.count = count;
//        }
//    }

    public String solve(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        List<String> list = new ArrayList<>();
        String next = st.nextToken();
        while (next != null){
            list.add(next);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=list.size()-1; i >= 0; i--){
            sb.append(list.get(i));
            if (i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int[] count = new int[26];
        for (char c : tasks){
            count[c-'A']++;
        }
        Map<Integer, List<Integer>> avail = new HashMap<>();
        for (int i=0; i < 26; i++){
            if (count[i] > 0) pq.add(count[i]);
        }
        int time = 0;
        while (!pq.isEmpty() || !avail.isEmpty()){
            if (avail.containsKey(time)){
                pq.addAll(avail.get(time));
                avail.remove(time);
            }
            if (!pq.isEmpty()){
                int cur = pq.poll();
                if (cur > 1){
                    avail.putIfAbsent(time+n+1, new ArrayList<>());
                    avail.get(time+n+1).add(cur-1);
                }
            }
            time++;
        }
        return time;
    }

//    public int leastInterval(char[] tasks, int n) {
//        int[] count = new int[26];
//        for (char i : tasks){
//            count[i-'A']++;
//        }
//        Arrays.sort(count);
//        int ans = 0;
//        int processed = 0;
//        int numActive = 26;
//        for (int i=0; i < 26; i++){
//            if (count[i] == count[25]){
//                int nRoute = (count[i]-processed-1)*(n+1) + numActive;
//                int actRoute = numActive*(count[i]-processed);
//                ans += Math.max(nRoute, actRoute);
//                break;
//            }
//            else {
//                ans += (count[i]-processed)*Math.max(n+1, numActive);
//                processed = count[i];
//                numActive--;
//            }
//        }
//        return ans;
//    }
}

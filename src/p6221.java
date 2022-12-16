import java.util.*;

public class p6221 {

    static class Vid {

        String id;
        int view;

        public Vid(String id, int view) {
            this.id = id;
            this.view = view;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, List<Vid>> v = new HashMap<>();
        Map<String, Long> total = new HashMap<>();
        for (int i=0; i < n; i++){
            v.putIfAbsent(creators[i], new ArrayList<>());
            v.get(creators[i]).add(new Vid (ids[i], views[i]));
            total.putIfAbsent(creators[i], 0L);
            total.put(creators[i], total.get(creators[i]) + views[i]);
        }
        long max = 0;
        List<String> highest = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (int i=0; i < n; i++){
            if (!seen.contains(creators[i])){
                seen.add(creators[i]);
                if (total.get(creators[i]) > max){
                    max = total.get(creators[i]);
                    highest.clear();
                    highest.add(creators[i]);
                }
                else if (total.get(creators[i]) == max){
                    highest.add(creators[i]);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String i : highest){
            Collections.sort(v.get(i), new Comparator<Vid>() {
                @Override
                public int compare(Vid vid, Vid t1) {
                    if (vid.view == t1.view){
                        return vid.id.compareTo(t1.id);
                    }
                    return t1.view-vid.view;
                }
            });
            List<String> temp = new ArrayList<>();
            temp.add(i);
            temp.add(v.get(i).get(0).id);
            ans.add(temp);
        }
        return ans;
    }
}

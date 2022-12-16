import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1847 {

    static class Query {
        int pre;
        int min;
        int index;

        public Query(int pre, int min, int index) {
            this.pre = pre;
            this.min = min;
            this.index = index;
        }
    }

    static class Room {
        int id;
        int size;

        public Room(int id, int size) {
            this.id = id;
            this.size = size;
        }
    }


    public static int[] closestRoom(int[][] rooms, int[][] queries) {
        List<Query> list = new ArrayList<>();
        for (int i=0; i < queries.length; i++){
            list.add(new Query(queries[i][0], queries[i][1], i));
        }
        Collections.sort(list, new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                return o2.min - o1.min;
            }
        });
        List<Room> rlist = new ArrayList<>();
        for (int i=0; i < rooms.length; i++){
            rlist.add(new Room (rooms[i][0], rooms[i][1]));
        }
        Collections.sort(rlist, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o2.size - o1.size;
            }
        });
        TreeSet<Integer> tset = new TreeSet<>();
        int[] ans = new int[queries.length];
        int ri = 0;
        for (Query i : list){
            while (ri < rlist.size() && rlist.get(ri).size >= i.min){
                tset.add(rlist.get(ri).id);
                ri++;
            }
            ans[i.index] = -1;
            int high = -1;
            if (tset.ceiling(i.pre) != null){
                high = tset.ceiling(i.pre) - i.pre;
                ans[i.index] = tset.ceiling(i.pre);
            }
            int low = -1;
            if (tset.floor(i.pre) != null){
                low = i.pre - tset.floor(i.pre);
                if (low <= high || high == -1){
                    ans[i.index] = tset.floor(i.pre);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int[][] rooms = {{2,2},{1,2},{3,2}};
        int[][] queries = {{3,1},{3,3},{5,2}};
        System.out.println(closestRoom (rooms, queries));
    }
}

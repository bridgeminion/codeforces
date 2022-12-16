import java.util.*;

public class p6223 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int numNodes = 0;
    int maxH = 0;
    int[] heights = new int[100005];
    int[] level = new int[100005];

    public int dfs (TreeNode cur, int l){
        numNodes = Math.max(numNodes, cur.val);
        level[cur.val] = l;
        if (cur.left == null && cur.right == null){
            return 0;
        }
        int h = 0;
        if (cur.left != null){
            h = Math.max(h, dfs (cur.left, l+1) + 1);
        }
        if (cur.right != null){
            h = Math.max(h, dfs (cur.right, l+1) + 1);
        }
        heights[cur.val] = h;
        maxH = Math.max(maxH, h);
        return h;
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs (root, 0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        System.out.println("START");
        for (int i=1; i <= numNodes; i++){
            map.putIfAbsent(level[i], new ArrayList<>());
            map.get(level[i]).add(heights[i]);
            System.out.println(i + " " + heights[i] + " " + level[i]);
        }
        for (int i : map.keySet()){
            Collections.sort(map.get(i), new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1-integer;
                }
            });
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i=0; i < m; i++){
            int q = queries[i];
            System.out.println("q is " + q + " " + level[q] + " " + map.get(level[q]).size());
            if (map.get(level[q]).size() == 1){
                if (map.get(level[q]).get(0) + level[q] == maxH){
                    ans[i] = level[q] - 1;
                }
                else {
                    ans[i] = maxH;
                }
            }
            else {
                if (map.get(level[q]).get(0) == heights[q]){
                    ans[i] = map.get(level[q]).get(1) + level[q];
                }
                else {
                    ans[i] = map.get(level[q]).get(0) + level[q];
                }
            }
        }
        return ans;
    }


}

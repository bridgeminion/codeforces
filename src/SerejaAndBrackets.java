//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class SerejaAndBrackets {
//
//    static class Range {
//        int l;
//        int r;
//        int index;
//
//        public Range(int l, int r, int index) {
//            this.l = l;
//            this.r = r;
//            this.index = index;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        int n = s.length();
//        int m = Integer.parseInt(br.readLine());
//        List<Range> list = new ArrayList<>();
//        for (int i=0; i < m; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int l = Integer.parseInt(st.nextToken());
//            int r = Integer.parseInt(st.nextToken());
//            list.add(new Range (l, r, i));
//        }
//        Stack<Integer> stack = new Stack<>();
//        for (int i=0; i < n; i++){
//            if (s.charAt(i) == ')'){
//                if (!stack.isEmpty()){
//                    list.add(new Range (stack.pop(), i, -1));
//                }
//            }
//            else {
//                stack.add(i);
//            }
//        }
//        Collections.sort(list, new Comparator<Range>() {
//            @Override
//            public int compare(Range o1, Range o2) {
//                if (o1.l == o2.l){
//                    if (o2.index == -1){
//                        return 1;
//                    }
//                    return -1;
//                }
//                return o2.l - o1.l;
//            }
//        });
//        int[] ans = new int[m];
//        PriorityQueue<Integer>
//        for (Range i : list){
//            if ()
//        }
//    }
//}

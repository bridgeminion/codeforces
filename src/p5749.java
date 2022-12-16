//public class p5749 {
//
//    public int getMinSwaps(String num, int k) {
//        int n = num.length();
//        int cur = 0;
//        for (int i=n-1; i >= 0; i--){
//            int temp = 0;
//            for (int j=i+1; j < n; j++){
//                if (num.charAt(j) > num.charAt(i)){
//                    temp++;
//                }
//            }
//            cur += temp * (n-1-i);
//            if (cur >= k){
//                cur -= temp * (n-1-i);
//            }
//        }
//    }
//}

import java.io.IOException;

public class p5892 {

    public static boolean aliceWins (int a, int b, int c, int alice, int r){
        if (a == 0 && b == 0 && c == 0){
            return false;
        }
        boolean ans;
        if (alice == 1){
             ans = false;
            if (a > 0 && r != 0){
                ans = ans || aliceWins(a-1, b, c, 1-alice, r);
            }

            if (c > 0 && r != 1){
                ans = ans || aliceWins(a, b, c-1, 1-alice, (r+2)%3);
            }
            if (b > 0 && r != 2){
                ans = ans || aliceWins(a, b-1, c, 1-alice, (r+1)%3);
            }
        }
        else {
             ans = true;
            if (a > 0 && r != 0){
                ans = ans && aliceWins(a-1, b, c, 1-alice, r);
            }

            if (c > 0 && r != 1){
                ans = ans && aliceWins(a, b, c-1, 1-alice, (r+2)%3);
            }
            if (b > 0 && r != 2){
                ans = ans && aliceWins(a, b-1, c, 1-alice, (r+1)%3);
            }
        }
        return ans;
    }

    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        int[] num = new int[3];
        for (int i=0; i < n; i++){
            num[stones[i]%3]++;
        }
        if (num[0]%2 == 1){
            return Math.abs(num[1]-num[2]) >= 3;
        }
        return num[1] != 0 && num[2] != 0;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(aliceWins(3,1, 5, 1, 0));
        int n = 9;
        for (int i=0; i <= n; i++){
            for (int j=0; j <= n; j++){
                for (int k=0; k <= n; k++){
                    boolean res = aliceWins(i, j, k, 1, 0);
                    if (res){
                        System.out.println(i + " " + j + " " + k + " ");
                        System.out.println("YES");
                    }
//                    else {
////                        System.out.println(i + " " + j + " " + k + " ");
////                        System.out.println("NO");
//                    }
//                    boolean res2 = j > i && (j != i + 1 || k % 2 == 1);
//                    if (res != res2){
//                        System.out.println("FAIL");
//                        System.out.println(i + " " + j + " " + k + " ");
//                        System.out.println(res + " " + res2);
//                    }
                }
            }
        }
        System.out.println(aliceWins(3,1,5, 1, 0));
        System.out.println(aliceWins(1,2,2, 1, 0));
        System.out.println(aliceWins(1,2,5, 1, 0));
        System.out.println(aliceWins(1,0,15, 1, 0));
        System.out.println(aliceWins(1,4,7, 1, 0));


    }
}

public class p5750 {

    public int maximumPopulation(int[][] logs) {
        int[] num = new int[3000];
        for (int i=0; i < logs.length; i++){
            for (int j=logs[i][0]; j < logs[i][1]; j++){
                num[j]++;
            }
        }
        int max = 0;
        int ans = -1;
        for (int i=0; i < 3000; i++){
            if (num[i] > max){
                max = num[i];
                ans = i;
            }
        }
        return ans;
    }
}

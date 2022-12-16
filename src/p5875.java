public class p5875 {

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String i : operations){
            if (i.equals("X++")||i.equals("++X")){
                ans++;
            }
            else {
                ans--;
            }
        }
        return ans;
    }

}

public class p28 {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if (haystack.length() < n) return -1;
        for (int i=0; i <= haystack.length()-n; i++){
            if (haystack.substring(i, i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

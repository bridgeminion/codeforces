import java.util.HashSet;
import java.util.Set;

public class p5161 {

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (int i=0; i < brokenLetters.length(); i++){
            set.add(brokenLetters.charAt(i));
        }
        boolean works = true;
        int ans = 0;
        for (int i=0; i < text.length(); i++){
            if (text.charAt(i) == ' '){
                if (works){
                    ans++;
                }
                works = true;
            }
            if (set.contains(text.charAt(i))){
                works = false;
            }
        }
        if (works){
            ans++;
        }
        return ans;
    }
}

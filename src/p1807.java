import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (int i=0; i < knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuilder ans = new StringBuilder();
        int last = -1;
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                last = i;
            }
            else if (s.charAt(i) == ')'){
                String temp = s.substring(last+1, i);
                if (map.containsKey(temp)){
                    ans.append(map.get(temp));
                }
                else {
                    ans.append('?');
                }
                last = -1;
            }
            else {
                if (last == -1){
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}

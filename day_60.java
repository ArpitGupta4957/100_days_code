import java.util.HashMap;
import java.util.Map;



class day_60 {
    public int maximumLength(String s) {
        Map<Pair<Character, Integer>, Integer> count = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            int subString = 0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    subString++;
                    Pair<Character, Integer> key = new Pair<>(s.charAt(i), subString);
                    count.put(key, count.getOrDefault(key, 0)+1);
                }
                else{
                    break;
                }
            }
        }
        int ans = 0;
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : count.entrySet()) {
            int length = entry.getKey().getValue(); // Access length from Pair
            if (entry.getValue() >= 3 && length > ans) {
                ans = length;
            }
        }
        return ans == 0 ? -1 : ans;
    }
    public static void main(String[] args) {
        day_60 obj = new day_60();
        System.out.println(obj.maximumLength("abcabc"));
        System.out.println(obj.maximumLength("abcabcbb"));
        System.out.println(obj.maximumLength("pwwkew"));
        System.out.println(obj.maximumLength("aab"));
        System.out.println(obj.maximumLength("dvdf"));
    }
}
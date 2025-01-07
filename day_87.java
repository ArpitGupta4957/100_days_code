import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    if (!result.contains(words[i])) {
                        result.add(words[i]);
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"mass","as","hero","superhero"};
        System.out.println(sol.stringMatching(words));
    }
}
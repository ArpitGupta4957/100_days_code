import java.util.HashMap;
import java.util.Map;

class day_78 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(c)) {
                charToWord.put(c, word);
            }

            if (!wordToChar.containsKey(word)) {
                wordToChar.put(word, c);
            }

            if (!charToWord.get(c).equals(word) || !wordToChar.get(word).equals(c)) {
                return false;
            }
        }
        return true;        
    }
    public static void main(String[] args) {
        day_78 obj = new day_78();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(obj.wordPattern(pattern, s));
    }
}
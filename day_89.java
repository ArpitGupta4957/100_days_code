class day_89 {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for(int i = 0;i<words.length;i++){
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        day_89 s = new day_89();
        String[] words = {"apple", "app", "apricot", "banana", "apocalypse"};
        String pref = "ap";
        System.out.println(s.prefixCount(words, pref));
    }
}
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i=0;
        for(String str : sentence.split(" ")){
            if(str.startsWith(searchWord)){                
                return i+1;
            }
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPrefixOfWord("i love eating burger", "burg"));
    }
}
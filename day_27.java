class day_27 {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder("");

        int i = 0;
        while (i < word.length()) {
            int Count = 0;

            char currChar = word.charAt(i);
            while (i < word.length() && Count < 9 && word.charAt(i) == currChar) {
                Count++;
                i++;
            }
            sb.append(Count).append(currChar);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        day_27 obj = new day_27();
        System.out.println(obj.compressedString("aabcccccaaa")); // Output: "a2b1c5a3"
    }
}
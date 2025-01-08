class day_88 {
    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Iterate through each word in the array
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Count valid prefix-suffix pairs for the current word
            count += countPrefixSuffix(words, i, word);
        }
        return count;
    }

    private static int countPrefixSuffix(String[] words, int idx, String word) {
        int count = 0;

        for (int i = idx + 1; i < words.length; i++) {
            String otherWord = words[i];

            // Check if word is a prefix
            boolean isPrefix = otherWord.startsWith(word);

            // Check if word is a suffix
            boolean isSuffix = otherWord.endsWith(word);

            // Increment count if both conditions are true
            if (isPrefix && isSuffix) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "appleorange", "orangeapple"};
        System.out.println(countPrefixSuffixPairs(words));
    }
}
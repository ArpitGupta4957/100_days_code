class day_41 {
    public int takeCharacters(String s, int k) {
        int n = s.length();

        int[] count = new int[3]; // count[0] for 'a', count[1] for 'b', count[2] for 'c'
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }

        // Sliding window approach
        int maxWindow = 0;
        int i = 0,j = 0;
        
        while(j<n){
            if(s.charAt(j) == 'a'){
                count[0]--;
            }
            else if(s.charAt(j) == 'b'){
                count[1]--;
            }
            else if(s.charAt(j) == 'c'){
                count[2]--;
            }

            while(i<=j && (count[0]<k || count[1]<k ||count[2]<k)){
                if(s.charAt(i) == 'a'){
                    count[0]++;
                }
                else if(s.charAt(i) == 'b'){
                    count[1]++;
                }
                else if(s.charAt(i) == 'c'){
                    count[2]++;
                }
                i++;
            }

            maxWindow = Math.max(maxWindow, j - i + 1);
            j++;
        }
        return n - maxWindow;
    }
    public static void main(String[] args) {
        day_41 obj = new day_41();
        System.out.println(obj.takeCharacters("aabbaaz", 3)); // Output: 1
        
    }
}
class day_85 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];

        for(int[] shift : shifts){
            if(shift[2] == 1){
                diff[shift[0]]++;
                diff[shift[1]+1]--;
            }
            else{
                diff[shift[0]]--;
                diff[shift[1]+1]++;
            }
        }

        for(int i=1;i<=n;i++){
            diff[i] += diff[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            int count = diff[i]%26;

            if(count<0){
                count += 26;
            }

            char curr = (char)((s.charAt(i)-'a' + count)%26 + 'a');
            sb.append(curr);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        day_85 d = new day_85();
        String s = "abc";
        int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
        System.out.println(d.shiftingLetters(s, shifts));
    }
}
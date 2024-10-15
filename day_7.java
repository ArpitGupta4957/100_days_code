class day_7 {
    public long minimumSteps(String s) {
        long swap = 0;
        int black = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') 
                swap += (long) black; 
            else
                black++; 
        }
        return swap;
    }
    public static void main(String[] args) {
        day_7 obj = new day_7();
        System.out.println(obj.minimumSteps("00110"));
    }
}
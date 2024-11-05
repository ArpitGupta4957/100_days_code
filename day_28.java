class day_28 {
    public int minChanges(String s) {
        int count = 0;
        int i = 0;

        while(i<s.length()){
            if(s.charAt(i)!=s.charAt(i+1)){
                count++;
            }

            i += 2;
        }
        return count;
    }
    public static void main(String[] args) {
        day_28 d = new day_28();
        System.out.println(d.minChanges("110"));
        
    }
}
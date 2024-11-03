class day_26 {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        return (s+s).contains(goal);
    }
    public static void main(String[] args) {
        day_26 obj = new day_26();
        System.out.println(obj.rotateString("abcde", "cdeab"));
        
    }
}
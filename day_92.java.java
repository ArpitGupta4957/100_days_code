public class Day95 {
    //Check if a Parentheses String Can Be Valid(leetcode)
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        int open = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                open--;
            }
            if (open < 0) {
                return false;
            }
        }

        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                close++;
            } else {
                close--;
            }
            if (close < 0) {
                return false;
            }
        }
        return true;
    }

    //Trapping Rain Water(gfg)
    public int maxWater(int arr[]) {
        int n = arr.length;
        int leftmax[] = new int[n];
        leftmax[0] = arr[0];
        
        for(int i=1; i<n; i++){
            leftmax[i] = Math.max(arr[i], leftmax[i-1]);
        }
        
        int rightmax[] = new int[n];
        rightmax[n-1] = arr[n-1];
        
        for(int i=n-2; i>=0; i--){
            rightmax[i] = Math.max(arr[i], rightmax[i+1]);
        }
        
        int trapwater = 0;
        for(int i=0; i<n; i++){
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trapwater += waterlevel - arr[i];
        }
        return trapwater;
   }

    public static void main(String[] args) {
        Day95 day95 = new Day95();
        String s = "()()", locked = "00";
        System.out.println(day95.canBeValid(s, locked));

        int arr[] = {3,0,2,0,4};
        System.out.println(day95.maxWater(arr));
    }
}

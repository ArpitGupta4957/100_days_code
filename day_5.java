import java.util.*;
class day_5 {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int start = 0;
        int last = s.length() - 1;

        while(start<=last){
            char currChar = s.charAt(start);
            char lastChar = s.charAt(last);

            if(!Character.isLetterOrDigit(currChar)){
                start++;
            }
            else if(!Character.isLetterOrDigit(lastChar)){
                last--;
            }
            else {
                if (Character.toLowerCase(currChar) != Character.toLowerCase(lastChar)) {
        			return false;
        		}
        		start++;
        		last--;
            }
        }

        return true;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        day_5 obj = new day_5();
        System.out.println(obj.isPalindrome(s));
    }
}
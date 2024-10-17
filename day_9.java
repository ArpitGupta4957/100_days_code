import java.util.*;
class day_9 {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        char[] arr = str.toCharArray();
        
        int maxEle = num; // Start with the initial number
        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                // Only swap if the character at j is greater than the character at i
                if (arr[i] < arr[j]) {
                    // Swap characters at indices i and j
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    
                    // Update maxEle with the new value if it's higher
                    maxEle = Math.max(maxEle, Integer.parseInt(new String(arr)));
                    
                    // Swap back to revert to original configuration
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        
        return maxEle;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        day_9 obj = new day_9();
        System.out.println(obj.maximumSwap(num));
    }
}

import java.util.*;
class day_2 {
    public int maxWidthRamp(int[] nums) {
        int count = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<nums.length;i++){
            if(st.isEmpty() || nums[i]<nums[st.peek()]){
                st.push(i);
            }
        }

        for(int j=nums.length - 1;j>=0;j--){
            while(!st.isEmpty() && nums[j]>=nums[st.peek()]){
                count = Math.max(count, j - st.pop());
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        day_2 obj = new day_2();
        System.out.println(obj.maxWidthRamp(arr));
    }
}
import java.util.*;
class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            pq.add(num);
        }

        while(k-- > 0){
            int maxEl = pq.poll();
            ans += maxEl;

            maxEl = (int) Math.ceil(maxEl / 3.0);
            pq.add(maxEl);
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.maxKelements(arr, k));
    }
}
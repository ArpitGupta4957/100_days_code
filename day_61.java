import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class day_61 {
    public int maximumBeauty(int[] nums, int k) {
        List<int[]> lst = new ArrayList<>();
        for(int num: nums){
            lst.add(new int[]{num-k, num+k});
        }

        lst.sort((a,b) -> Integer.compare(a[0], b[0]));
        Deque<Integer> que = new ArrayDeque<>();
        int maxBeauty = 0;
        for(int[] list : lst){
            while(!que.isEmpty() && que.peekFirst()<list[0]){
                que.pollFirst();
            }
            que.offer(list[1]);

            maxBeauty = Math.max(maxBeauty, que.size());
        }
        return maxBeauty;
    }
    public static void main(String[] args) {
        day_61 obj = new day_61();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(obj.maximumBeauty(nums, k));
    }
}
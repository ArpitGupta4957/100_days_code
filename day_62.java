import java.util.Collections;
import java.util.PriorityQueue;

class day_62 {

    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) {
            queue.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int curr = queue.poll();
            queue.add((int) Math.sqrt(curr));
        }

        Object[] remaining = queue.toArray();
        long result = 0;
        for (Object pile : remaining) {
            result += (int) pile;
        }
        return result;
    }
    public static void main(String[] args) {
        day_62 solution = new day_62();
        int[] gifts = { 5, 17, 100, 11 };
        int k = 3;
        long result = solution.pickGifts(gifts, k);
        System.out.println(result);
    }
}
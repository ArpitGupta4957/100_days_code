import java.util.*;
public class day_4 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(!pq.isEmpty() && pq.peek()<start){
                pq.poll();
            }

            pq.offer(end);
        }

        return pq.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        day_4 obj = new day_4();
        System.out.println(obj.minGroups(intervals));
    }
}

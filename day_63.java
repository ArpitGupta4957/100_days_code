import java.util.Arrays;

class day_63 {
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;

        int[][] arr = new int[n][2];
        for(int i = 0;i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        boolean[] visited = new boolean[n];

        for(int i = 0;i<n;i++){
            int val = arr[i][0];
            int idx = arr[i][1];

            if(!visited[idx]){
                score += val;
                visited[idx] = true;

                if(idx-1>=0){
                    visited[idx-1] = true;
                }
                if(idx+1<n){
                    visited[idx+1] = true;
                }
            }
        }
        return score;
    }
    public static void main(String[] args) {
        day_63 solution = new day_63();
        int[] nums = {1,2,3,4,5};
        System.out.println(solution.findScore(nums));
    }
}
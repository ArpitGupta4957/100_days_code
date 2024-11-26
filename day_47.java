import java.util.Arrays;

class day_47 {
    public int findChampion(int n, int[][] edges) {
        boolean[] mp = new boolean[n];
        Arrays.fill(mp, true);

        for(int[] edge: edges){
            int looser = edge[1];
            mp[looser] = false;
        }

        int champion = -1;
        int chCount = 0;

        for(int i = 0;i<n;i++){
            if(mp[i]){
                champion = i;
                chCount++;
            }
        }

        return chCount == 1? champion : -1;
    }
    public static void main(String[] args) {
        day_47 d = new day_47();
        int n = 5;
        int[][] edges = {{0, 2}, {0, 3}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(d.findChampion(n, edges));
    }
}
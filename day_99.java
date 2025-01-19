import java.util.PriorityQueue;

class day_99 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if(m<3 && n<3){
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean[][] visited = new boolean[m][n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        int trappedWater = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int height = curr[0];
            int x = curr[1];
            int y = curr[2];
            level = Math.max(level, height);

            for(int i = 0;i<4;i++){
                int u = x + dir[i];
                int v = y + dir[i+1];

                if(isValid(u, v, m, n) && !visited[u][v]){
                    visited[u][v] = true;
                    pq.offer(new int[]{heightMap[u][v], u, v});
                    if(heightMap[u][v]<level){
                        trappedWater += level - heightMap[u][v];
                    }
                }
            }
        }
        return trappedWater;
    }

    private static boolean isValid(int x, int y, int m, int n){
        return (x>=0 && x<m && y>=0 && y<n);
    }
    public static void main(String[] args) {
        int[][] heightMap = {{1,4,3,1,3,2},
                             {3,2,1,3,2,4},
                             {2,3,3,2,3,1}};
        day_99 obj = new day_99();
        System.out.println(obj.trapRainWater(heightMap));
    }
}
import java.util.HashMap;
import java.util.Map;

class day_100{
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> hm = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                hm.put(mat[i][j], new int[]{i, j});
            }
        }
        
        int[] rowC = new int[m];
        int[] colC = new int[n];

        for(int i=0;i<arr.length;i++){
            int[] coor = hm.get(arr[i]);
            int x = coor[0];
            int y = coor[1];

            rowC[x]++;
            colC[y]++;
            if(rowC[x] == n || colC[y] == m){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        day_100 d = new day_100();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(d.firstCompleteIndex(arr, mat));
    }
}
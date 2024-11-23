class day_44{
    public char[][] rotateBox(char[][] box) {
        int m = box.length, n = box[0].length;

        for(char[] row: box){
            int dropPos = n-1;

            for(int i = n-1;i>=0;i--){
                if(row[i] == '*'){
                    dropPos = i - 1;
                }
                else if(row[i] == '#'){
                    char temp = row[i];
                    row[i] = row[dropPos];
                    row[dropPos] = temp;
                    dropPos--;
                }
            }
        }

        char[][] res = new char[m][n];
            for(int i = 0;i<m;i++){
                for(int j = 0;j<n;j++){
                    res[i][j] = box[m-1-j][i];
                }
            }
        return res;
    }
    public static void main(String[] args) {
        day_44 d = new day_44();
        char[][] box = {{'#','.','.'},{'#','.','.'},{'#','.','.'}};
        char[][] res = d.rotateBox(box);
        for(char[] row: res){
            for(char c: row){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
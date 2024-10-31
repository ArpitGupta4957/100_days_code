class day_23 {
    public boolean searchMatrix(int[][] arr, int t) {
        if(arr==null || arr.length<1 || arr[0].length <1) return false;
        int r=0;
        int c=arr[0].length-1;
        while(c>=0 && r <=arr.length-1){
            if(t==arr[r][c]) return true;
            else if(t<arr[r][c]) c--;
            else if(t> arr[r][c]) r++;
        }
        return false;
    }
    public static void main(String[] args) {
        day_23 d = new day_23();
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(d.searchMatrix(arr, 3));
        
    }
}
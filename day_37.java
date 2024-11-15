class day_37 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;

        while(j>0 && arr[j]>=arr[j-1]){
            j--;
        }

        int i = 0;
        int result = j;

        while(i<j && (i == 0 || arr[i]>=arr[i-1])){

            while(j<n && arr[i]>arr[j]){
                j++;
            }
            result = Math.min(result, j-i-1);
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        day_37 d = new day_37();
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(d.findLengthOfShortestSubarray(arr));
    }
}
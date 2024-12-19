class day_69 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 0;
        int maxSeen = 0;

        for(int i = 0;i<n;i++){
            maxSeen = Math.max(maxSeen, arr[i]);
            if(maxSeen == i){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        day_69 d = new day_69();
        int[] arr = {4,3,2,1,0};
        System.out.println(d.maxChunksToSorted(arr));
    }
}
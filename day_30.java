class day_30 {
    public int largestCombination(int[] candidates) {
        int result = 0;
        for(int i =0;i<24;i++){
            int ith_Count = 0;
            for(int num : candidates){
                if((num & (1<<i)) != 0){
                    ith_Count++;
                }
            }
            result = Math.max(result, ith_Count);
        }
        return result;
    }
    public static void main(String[] args) {
        day_30 obj = new day_30();
        int[] candidates = {16,17,71,62,12,24,14};
        System.out.println(obj.largestCombination(candidates));

    }
}
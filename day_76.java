class day_76 {
    public int maxScoreSightseeingPair(int[] values) {
        int maxSum = values[0];
        int maxScore = Integer.MIN_VALUE;

        for(int j = 1;j<values.length;j++){
            maxScore = Math.max(maxScore ,maxSum + values[j] -j);

            maxSum = Math.max(maxSum, values[j] + j);
        }
        return maxScore;
    }
    public static void main(String[] args) {
        day_76 obj = new day_76();
        int[] values = {8, 1, 5, 2, 6};
        System.out.println(obj.maxScoreSightseeingPair(values));
    }
}
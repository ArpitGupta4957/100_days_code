class day_68 {
    public int[] finalPrices(int[] prices) {
        int[] arr = prices.clone();
        for (int i = 0; i < prices.length; i++) {
            int curr = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (curr >= prices[j]) { 
                    arr[i] = curr - prices[j];
                    break;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        day_68 d = new day_68();
        int[] arr = {8,4,6,2,3};
        System.out.println(d.finalPrices(arr));
    }
}
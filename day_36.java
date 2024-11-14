class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int high = 0;
        for(int num : quantities){
            high = Math.max(high, num);
        }
        int low = 1;
        
        while(low<high){
            int mid = low + (high - low)/2;
            int maxStores = 0;

            for(int num : quantities){
                maxStores += (num + mid - 1)/mid;
            }

            if(maxStores > n){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[] quantities = {2, 2, 4, 3, 7, 4};
        System.out.println(solution.minimizedMaximum(n, quantities));
    }
}
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = 0;

        for(int num : nums){
            high = Math.max(high, num);
        }
        int res = high;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(nums, maxOperations, mid) == true){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }

    private boolean isPossible(int[] nums, int maxOperations, int mid){
        int totOops = 0;

        for(int num : nums){
            int ops = num/mid;

            if(num % mid == 0){
                ops -= 1;
            }
            totOops += ops;
        }

        return totOops<=maxOperations;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9, 9, 9, 7};
        int maxOperations = 2;
        System.out.println(solution.minimumSize(nums, maxOperations));
    }
}
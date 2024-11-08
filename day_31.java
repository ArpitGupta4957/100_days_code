class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int XOR = 0;
        int[] arr = new int[nums.length];
        for(int i = 0;i<nums.length;i++){ // here we are finding the Xor of whole array 
            XOR ^= nums[i]; //so that we don't have to find the xor of (nums-1) again again
        }

        // now find the mask so as to get the value of k, (2^maximumBit - 1)
        int mask = ((1<<maximumBit)-1);

        for(int i = 0;i<nums.length;i++){
            int k =  XOR ^ mask; // here we get the max value of k everytime 
            arr[i] = k;

            XOR ^= nums[nums.length -1 -i]; // generate xox of nums[i] removing last digit
        }
        return arr;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 3, 4, 5};
        int maximumBit = 2;
        int[] result = s.getMaximumXor(nums, maximumBit);
        for(int i = 0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}
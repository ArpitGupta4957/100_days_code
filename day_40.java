import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currSum = 0;
        Set<Integer> set = new HashSet<>();
        int start  = 0;

        for(int i = 0;i<nums.length;i++){
            while(set.contains(nums[i])){
                set.remove(nums[start]);
                currSum -= nums[start];
                start++;
            }

            set.add(nums[i]);
            currSum += nums[i];

            if(i - start +1 == k){
                maxSum = Math.max(maxSum, currSum);

                set.remove(nums[start]);
                currSum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,5,2,3,2};
        int k = 3;
        System.out.println(solution.maximumSubarraySum(nums, k));
    }
}
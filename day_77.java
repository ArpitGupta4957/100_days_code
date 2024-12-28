import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean findSubarrays(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length-1;i++){
            int sum = 0;
            for(int j = i;j<i+2;j++){
                sum += nums[j];
            }
            if(hm.containsKey(sum)){
                return true;
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4, 0, 1, 2, 3};
        System.out.println(s.findSubarrays(nums));
    }
}
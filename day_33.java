import java.util.*;
class day_33 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        
        List<Integer> arr = new ArrayList<>(Collections.nCopies(32, 0));

        while (j < n) {
            updateBit(nums[j], arr, 1);

            while (i <= j && getDecimalFromBinary(arr) >= k) {
                result = Math.min(result, j - i + 1);
                updateBit(nums[i], arr, -1);
                i++;
            }
            j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void updateBit(int num, List<Integer> vec, int val) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                vec.set(i, vec.get(i) + val);
            }
        }
    }

    private int getDecimalFromBinary(List<Integer> vec) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (vec.get(i) > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }
    public static void main(String[] args) {
        day_33 obj = new day_33();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 3;
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }
}
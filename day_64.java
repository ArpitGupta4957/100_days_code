import java.util.TreeMap;

class day_64 {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0;
        long count = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (Math.abs(map.lastKey() - map.firstKey()) > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
    public static void main(String[] args) {
        day_64 solution = new day_64();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.continuousSubarrays(nums));
    }
}
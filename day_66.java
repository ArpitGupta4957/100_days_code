class day_66 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int[] result = nums.clone();

        // Process `k` smallest elements and modify the array in place
        while (k > 0) {
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (result[i] < result[minIndex]) {
                    minIndex = i;
                }
            }

            // Multiply the smallest element
            result[minIndex] *= multiplier;

            k--;
        }
        return result;
    }
    public static void main(String[] args) {
        day_66 solution = new day_66();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int multiplier = 2;
        int[] result = solution.getFinalState(nums, k, multiplier);
        System.out.println(java.util.Arrays.toString(result));
    }
}
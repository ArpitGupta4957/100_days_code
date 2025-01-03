class day_83 {
    public static int waysToSplitArray(int[] nums) {
        long leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        int validSplits = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                validSplits++;
            }
        }
        return validSplits;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 5, 0};
        System.out.println(waysToSplitArray(nums));
    }
}
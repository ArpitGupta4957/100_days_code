class day_18 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Finding the mid using integer division
            int mid = low + (high - low) / 2;

            // Target value is present at the middle of the array
            if (nums[mid] == target) {
                return mid;
            }
            // Target value is present in the low subarray
            else if (target < nums[mid]) {
                high = mid - 1;
            }
            // Target value is present in the high subarray
            else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        // Target value is not present in the array
        return -1;
    }
    public static void main(String[] args) {
        day_18 obj = new day_18();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(obj.search(nums, target));
        
    }
}
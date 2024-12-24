class day_73 {
    public int jump(int[] nums) {
        int jumps = 0;  // Number of jumps
        int l = 0, r = 0;  // Left and right pointers for the current range

        while (r < nums.length - 1) {  // Stop once the farthest range reaches the end
            int farthest = 0;

            // Explore all positions in the current range
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Update the range for the next jump
            l = r + 1;
            r = farthest;

            // Increment jump count
            jumps++;

            // If the current range cannot progress, return -1 (optional for invalid cases)
            if (l > r) return -1;
        }
        return jumps;
    }
    public static void main(String[] args) {
        day_73 d = new day_73();
        int[] nums = {2,3,1,1,4};
        System.out.println(d.jump(nums));  // Output: 2
    }
}
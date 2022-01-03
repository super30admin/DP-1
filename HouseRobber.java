public class HouseRobber {
    // TC O(N)
    // SC O(1)
    public int rob(int[] nums) {
        if (nums == null)
            return 0;
        int n = nums.length;
        int skip = 0;

        // int [][] dp = new int[nums.length][2];
        int take = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = skip;
            skip = Math.max(take, skip);
            take = temp + nums[i];

        }
        return Math.max(skip, take);
    }
}

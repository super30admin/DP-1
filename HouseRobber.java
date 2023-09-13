public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int skip = 0;
        int take = nums[0];
        int tempSkip = 0; 
        for (int i = 1; i < n; i++) {
            tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + nums[i];
        }
        return Math.max(skip, take);
    }
}

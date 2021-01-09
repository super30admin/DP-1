
public class HouseRobber {
	//Recursion approach
    /*public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount){
        //base
        if(index >= nums.length) return amount;
        //logic
        //when choosen
        int case1 = helper(nums, index + 2, amount + nums[index]);
        //when not choosen
        int case2 = helper(nums, index + 1, amount);
        return Math.max(case1, case2);
    }
    */
    /*
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
    */
	
	public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int skip = 0;
        int take = nums[0];
        for(int i = 1;i<nums.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + nums[i];
        }
        return Math.max(skip, take);
    }
    
    public static void main(String[] args) {
    	int[] nums = {7,1,1,8};
    	System.out.println(HouseRobber.rob(nums));
	}
    
}

import java.util.Arrays;

public class HouseRobber_LC_198 {

//Exhaustive
    public int robTLE(int[] nums) {
        return helper(nums,0);
    }
    private int helper(int []nums, int index) {
        //base case
        if(index >= nums.length) return 0;

        //logic
        //rob
        int rob = nums[index]+ helper(nums, index+2);
        //not rob
        int notRob = helper(nums, index+1);
        return Math.max(rob, notRob);
    }

//Time complexity - O(N)
//Space Complexity - O(N)
//Top down

    private int dp[];
    public int robTopDown(int[] nums) {
        this.dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper1(nums, 0);
    }
    private int helper1(int [] nums, int index) {
        //base case
        if(index >= nums.length) return 0;
        if(dp[index] != -1){
            return dp[index];
        }
        //rob
        int rob = nums[index]+ helper(nums, index+2);
        //not rob
        int notRob = helper(nums, index+1);
        dp[index] = Math.max(rob, notRob);
        return dp[index];
    }
}


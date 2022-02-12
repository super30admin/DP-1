// Time Complexity:     O(n)
// Space Complexity:    O(n)
// where n is length of given array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

package src;

public class RobberyProblem {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        RobberySolution rp = new RobberySolution();
        System.out.println(rp.rob(nums));
    }
}

class RobberySolution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = -1;
        }
        int ans = rob(nums, 0);
        return ans;


// ****************************** Another Approach ******************************
//        final int n = nums.length;
//        if (n == 0)
//            return 0;
//        if (n == 1)
//            return nums[0];
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < n; ++i)
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//
//        return dp[n - 1];
    }
    private int rob(int[] nums, int index)
    {
        if(index >= nums.length)                                    // if traversed all houses
            return 0;

        if(dp[index] != -1)                                         // put all values in dp array
            return dp[index];

        int notChoose = rob(nums, index+1);                   // if current house not choosed then next can be
        int choose = rob(nums, index+2);                      // if current house choosed then second next can be
        choose += nums[index];

        return dp[index] = Math.max(notChoose, choose);             // keep maximum robbery
    }
}
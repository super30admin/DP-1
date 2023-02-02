/*
approach: exhaustive
time: O(2^n)
space: O(2^n)

dp approach is given below but is not working.
 */

public class Problem2 {

    static int rob(int[] nums) {
        if (nums==null || nums.length==0) return -1;
        int robbedAmount = 0;
//        return helper(nums, robbedAmount, 0, false);
        return dpHelper(nums);
    }

    static int helper(int[] nums, int robbedAmount, int index, boolean adjRobbed) {

        if (index>=nums.length) return robbedAmount;
        int case1 = 0;
        if (!adjRobbed)
        //case1 - if we chose to rob current house
        case1 = helper(nums, robbedAmount+nums[index], index+1, true );

        //case2 - we chose not to rob current house
        int case2 = helper(nums, robbedAmount, index+1, false);

        return Math.max(case1, case2);
    }

    static int dpHelper(int nums[]) {
        int r = nums.length, c = 2;
        int[][] dp = new int[r+1][c+1];
        boolean adjRobbed = false;
        int robbedAmount  = 0;

        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[0].length;j++) {
                if (adjRobbed){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    adjRobbed = true;
                    dp[i][j] = nums[i-1]+dp[i-1][j];
                }
            }
        }

        return dp[r][c];
    }
    public static void main(String args[]) {
        System.out.println("max amount thief can rob is "+rob(new int[]{1,2,3,4}));
    }
}

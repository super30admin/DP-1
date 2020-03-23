// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HouseRobber {
    public static int rob(int[] nums) {

        // Base Cases
        if(nums == null || nums.length == 0){
            return 0;
        }
        // we either skip the current house or we skip the next house
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // Additional space for storing max at that house
        int[] dp = new int[nums.length];

        // Initializing base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Starting from house 2, we either choose maximum of (current house and add till i-2 th robbed money in it) or (till i-1 st robbed money)
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        // return last elelment in the array
        return dp[nums.length-1];
    }

    public static void main(String args[]){
        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(rob(arr));
    }
}

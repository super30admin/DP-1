//Time Complexity: O(n) n be the size of input array.
//Space complexity: O(n), for dp array

// Followed botoom up approach started from the smallest case possible.

public class HouseRobber {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];

        for (int index = 0; index < nums.length; ++index) {
            int select = index - 2 < 0 ? (nums[index]) : dp[index - 2] + nums[index];

            int notSelect = index - 1 < 0 ? 0 : dp[index - 1];

            dp[index] = Math.max(select, notSelect);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}

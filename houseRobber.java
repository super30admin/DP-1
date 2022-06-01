// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // first approch
    public static int rob1(int[] nums) {

        // dp array
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // for robing house at index i and avoid adjacent house
            int rob = nums[i];
            // for i > 1 we have to add previously robbed house amount that is not adjacent.
            // So,
            if (i > 1)
                rob += dp[i - 2];
            // if we are not robbing the house at index i. We already robbed house previos
            // to index i
            int notRob = dp[i - 1];
            // we are taking maximum amout that from robbing and not robbing current house
            // and stroing it in dp array
            dp[i] = Math.max(rob, notRob);
        }

        // so our last maximum amount will be stored at last index in dp array so we are
        // returning it.
        return dp[nums.length - 1];
    }

    // second approch
    public static int rob2(int[] nums) {

        // rather than using whole dp array I only need two previos element so, I can
        // manage this by using two variables than whole array. So,
        int prev = nums[0];

        // to store amount that is not adjacent to robbed house
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            // for robing house at index i and avoid adjacent house
            int rob = nums[i];
            // for i > 1 we have to add previously robbed house amount that is not adjacent.
            // So,
            if (i > 1) {
                rob += prev2;
            }

            // if we are not robbing the house at index i. We already robbed house previos
            // to index i
            int notRob = prev;

            // current maximum amount that is robbed from chosing between robbing and not
            // robbing current house
            int current = Math.max(rob, notRob);
            // so here we are storing current robbed amout to previously robbed amount for
            // next iteration and previosly robbed amount to prev2
            prev2 = prev;
            prev = current;
        }
        // maximum amount will be stored in prev
        return prev;

    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 1 };
        System.out.println("maximum amount can be robbed is: " + rob1(nums));
        System.out.println("maximum amount can be robbed is: " + rob2(nums));

    }
}
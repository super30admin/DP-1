//Time Complexity: O(n) where n is the number of houses
//Space Complexity: O(n) since we are keeping track of max amount that can be robbed at any index
//Did this code successfully run on Leetcode : Yes

/**
 * Using dynamic programming approach to calculate the max amount robbed at any point starting from the back of the array so that
 * If there is no house, then robbed amount is 0
 * If there is only 1 house, then robbed amount is from one house
 * If there are 3 houses, then robbed amount is max (sum(currentAmount + maxAmount(currentAmount +2), maxAmount(currentAmount + 1))
 */

public class HouseRobber {

    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        int[] maxAmount = new int[n + 1];
        maxAmount[n] = 0;
        maxAmount[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxAmount[i] = Math.max(nums[i] + maxAmount[i + 2], maxAmount[i + 1]);
        }

        return maxAmount[0];

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{100, 2, 3, 100})); // 200
    }
}

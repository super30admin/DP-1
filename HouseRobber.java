package week3;

public class HouseRobber {

    public int houseRobberRecursive(int[] houses) {
        return helper(houses, 0, 0);
    }

    private int helper(int[] houses, int i, int max) {
        if(i == houses.length) {
            return max;
        }
        //don't pick
        int max1 = helper(houses, i+1, max);
        //pick
        int max2 = helper(houses, i+2, max+houses[i]);
        return Math.max(max1, max2);
    }

    public int rob(int[] houses) {
        int[] dp = new int[houses.length];
        int robbings = dp[0];
        dp[0] = houses[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2 ; i < houses.length ; i++) {
            dp[i] = Math.max(dp[i-1], houses[i] + dp[i-2]);
        }
        return dp[dp.length - 1];
    }

}

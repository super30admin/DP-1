public class Problem2 {
    public int rob(int[] nums) {
        //Time Complexity O(2^n)
        // Space Complexity O(n)
        if (nums == null || nums.length == 0) return 0;
        return getMaxMoney(nums, 0, 0);
    }

    private int getMaxMoney(int[] nums, int index, int total) {
        //base case
        if (index >= nums.length) {
            return total;
        }
        //choose case
        //not choosing index value
        int value1 = getMaxMoney(nums, index + 1, total);
        //choosing case
        int value2 = getMaxMoney(nums, index + 2, total + nums[index]);
        return Math.max(value1, value2);
    }

    //Time Complexity O(n)
    // Space Complexity O(n) as creating new 2d array size of n
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    //Time Complexity O(n)
    // Space Complexity O(1)
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length + 1][2];
        int taken = nums[0];
        int skip = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, taken);
            taken = temp + nums[i];
        }
        return Math.max(skip, taken);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Problem2 problem2 = new Problem2();
        int result = problem2.rob2(nums);
        System.out.println("Result value " + result);
    }
}

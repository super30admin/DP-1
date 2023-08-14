public class Hoserobber {

    public static void main(String[] args) {

        int[] arr = { 1,2,3,1};

        Hoserobber obj = new Hoserobber();

        int obj1 = obj.robber(arr);

        System.out.println("Max value is =" + obj1);

    }

    public int robber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;

        if (nums.length < 2)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];

    }

}
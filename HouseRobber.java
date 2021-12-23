public class HouseRobber {
    // TC: O(N)
    // SC: O(1)
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[][] val = new int[nums.length][2];
        // initializing the skip and take value in 2d array
        val[0][0] = 0;
        val[0][1] = nums[0];

        // for skip (0th column) taking the maximum of the above rows 2 col values
        // for take (1st column) add the above row skip value and the present row's nums
        // value
        for (int i = 1; i < val.length; i++) {
            val[i][0] = Math.max(val[i - 1][0], val[i - 1][1]);
            val[i][1] = val[i - 1][0] + nums[i];
        }

        return Math.max(val[val.length - 1][0], val[val.length - 1][1]);
    }

}

public class HouseRobber1 {

    public int rob(int[] nums) {
        // return  exhaustiveApproach(nums, 0, 0);
        return dpApproach(nums);
    }

    private static int exhaustiveApproach(int[] nums, int houseIndex, int maxProfit){
        //base
        //when all houses are picked
        if(houseIndex >= nums.length) return maxProfit;

        //logic
        //pick a house
        int case1 = exhaustiveApproach(nums, houseIndex+2, maxProfit + nums[houseIndex]);
        //not pick a house
        int case2 = exhaustiveApproach(nums, houseIndex+1, maxProfit);
        return Math.max(case1, case2);
    }

    private static int dpApproach(int[] nums){

        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][]dp = new int[n][2];
        //setting value of first house when selected
        dp[0][1] = nums[0];
        for(int i = 1; i < n; i++){
            //skip house
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //rob house
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        //return highest value at the end of dp matrix
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public static void main(String[] args){
        System.out.println("Max amt robbed: "+ exhaustiveApproach(new int[]{1,2,3,1}, 0, 0));
        System.out.println("Max amt robbed: "+ dpApproach(new int[]{1,2,3,1}));
    }


}

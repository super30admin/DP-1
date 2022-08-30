package Day8;

//Time and Space Complexity: O(n)
public class RobberDP1 {

    public int rob(int nums[]){
        //edge
        if(nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i = 1; i <nums.length; i++){
            for(int j=0; j<2; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][0], dp[i-1][1]);
                }
                else{
                    dp[i][j] = dp[i-1][0] + nums[i];
                }
            }
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length-1][1]);
    }

    public static void main(String args[]){
        RobberDP1 ob = new RobberDP1();

        int nums[] = new int[]{1,2,3,1};

        System.out.println("Max amount that can be robbed: "+ ob.rob(nums));
    }
}

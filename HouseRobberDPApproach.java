class HouseRobberDPApproach{
    //Using DP and maintaing 2D array to store the previous values.
    // TC will be O(N), as traversing only once.
    //SC will O(N), as array is of N*2 and ignoring 2.
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){       //Base condn to check array is not empty
            return 0;
        }
        int[][] dp= new int[nums.length][2];        //declare 2D array to store the rSum
        dp[0][0]=0;                                 //Staring from ind 0 and not choosing 1st house
        dp[0][1]=nums[0];                           //Starting for index 0 and choosen 1st house

        for(int i=1; i<nums.length; i++){           //To traverse over N houses
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]);      //Case 1 when not choosing then populate with th previous max value
            dp[i][1]= dp[i-1][0]+nums[i];           //Case 2 when choosing then populate with previous not choosen value + the current value.
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);     //return the max value
    }

    public static void main(String[] args){
        HouseRobberDPApproach obj= new HouseRobberDPApproach();
        int[] nums={1,2,3,1};
        System.out.println(obj.rob(nums));
    }
}
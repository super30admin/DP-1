//Time complexity: O(n)
//Space complexity: O(1)
public class RobAlternateHouse {
    public static int rob(int[] nums) {
        if(nums.length == 0) 
            return 0;
        int len = nums.length;
        int[] dp = new int[len+1];
        //Default setting to min value
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=len; i++){
            // (Element default value + Element 1), (Nums Element 0), (Nums Element 1)
            dp[i] = findMax(dp[i-2]+nums[i-1], dp[i-1], nums[i-1]);
        }
        return dp[len];
    }
    static int findMax(int a, int b, int c){
        return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
    }
    public static void main(String[] args) {
        int[] val = {1,2,3,1};
        System.out.println(rob(val));
    }
}
/*
Time Complexity:O(n)
Space Complexity:O(n)
Approach:
-Taking a dp array in which storing amount if we rob or we dont rob the house
-if we choose to rob the house we cannot rob the previous house(so we will take not condition from row above)
-if we choose to not rob then we can choose max from a row above as we can rob or not rob previous house
-at the end we can return max from the last row that will contain cumulative amount we get by robbing house
 */
 public class HouseRobber{
    public static int maxAmount(int[] num){
        int[][] dp = new int[num.length][2];
        dp[0][0] = 0;
        dp[0][1] = num[0];
        for(int i = 1; i < num.length; i++){
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]= num[i]+dp[i-1][0];
        }
        int result = Math.max(dp[num.length-1][0],dp[num.length-1][1]);
        return result;
    }
public static void main(String args[]){
    System.out.println(maxAmount(new int[]{1,2,3,1}));
    System.out.println(maxAmount(new int[]{100,2,3,500}));

}
}
//time complexity: O(n)
//space complexity: O(1)
public class HouseRobber {
    public int RobbedHouses(int[] arr){
        if(arr == null && arr.length==0) return 0;
        int [] dp = new int[arr.length];
        dp[0]=arr[0]; dp[1]= Math.max(arr[0],arr[1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);

        }
    return dp[arr.length-1];
    }
    public static void main(String args[]){
        HouseRobber obj = new HouseRobber();
        System.out.print(obj.RobbedHouses(new int[]{2,7,9,3,1}));
    }
}

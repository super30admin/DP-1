// Time Complexity : o(m*n) m- coins n -target
// Space Complexity :o(m*n)

import java.util.*;
class CoinChange {
    public static int calculateMinCoins(int arr[], int target){
        int [][] dp = new int[arr.length+1][target+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=9999;
        }
        for(int i=1; i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<arr[i-1]){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= Math.min(dp[i-1][j],dp[i][j-arr[i-1]]+1);
                }
            }
            
        }
        int result = dp[dp.length-1][dp[0].length-1];
        if(result>=9999) return -1;
        return result;
       
   
    }
  
	public static void main (String[] args) {
	  int arr[] = {1,2,5};
		System.out.println(calculateMinCoins(arr,11));
		
	}
}
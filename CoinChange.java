
// Time Complexity :O(n*m)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we have choose and not choose case
//choose: coin+remaining amount
//not choose: remaining amount

import java.util.*;
public class CoinChange{
    public static void main(String agrs[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0;i<n;i++)
            coins[i]=sc.nextInt();
        int amount=sc.nextInt();
        int m=amount;
        int dp[]=new int[m+1];
        for(int i=1;i<=m;i++)
            dp[i]=99999;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j<coins[i-1]) //choose case is not available
                    dp[j]=dp[j];
                else
                dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
            }
        }
        if(dp[m]==99999)
            System.out.println(-1);
        System.out.println(dp[m]);
    }
}
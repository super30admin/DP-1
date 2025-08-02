// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//since greedy doesnot work we go for dp here if we have only one house we can rob it
//if we have two houses we rob the one with maximum money
//we have 2 cases choose and not choose
//choose: house+next to next house
//not choose: previous house



import java.util.*;
public class HouseRobber{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int houses[]=new int[n];
        for(int i=0;i<n;i++)
            houses[i]=sc.nextInt();
        if(n==1)
            System.out.println(houses[0]);
        int dp[]=new int[n];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[0],houses[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],houses[i]+dp[i-2]);
        }
        System.out.println(dp[n-1]);
    }
}
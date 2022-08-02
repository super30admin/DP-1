class Solution {
    /*
     * Time - O(m*n)
     * Space - O(m*n)
    */
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] arr = new int[m+1][n+1];
        arr[0][0] = 0;
        // Set first row values to more than maximum amount possible
        for (int j=1; j<arr[0].length; j++) 
            arr[0][j] = amount+1;
        for (int i=1; i<arr.length; i++) {
            for (int j=1; j<arr[0].length; j++) {
                // If amount is less than coin value
                if (j<coins[i-1]) 
                    arr[i][j] = arr[i-1][j];
                else {
                    arr[i][j] = Math.min(arr[i-1][j], 1+arr[i][j-coins[i-1]]);
                }
            }
        }
        int result = arr[m][n];
        if (result == amount+1) return -1;
        else return result;
    }
}
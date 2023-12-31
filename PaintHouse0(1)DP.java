//TC = O(3n)
//SC = O(1)
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        for(int i = n-2; i >=0; i-- )
        {
            int tempCostR = costR;
            costR =  costs[i][0] + Math.min(costB, costG);
            int tempCostB = costB;
            costB = costs[i][1] + Math.min(tempCostR, costG);
            costG = costs[i][2] + Math.min(tempCostR, tempCostB);
        }
        return Math.min(costR, Math.min(costB, costG));
    }
}
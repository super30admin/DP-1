'''
time complexity: O(N)
space complexityL O(1)
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        costR = costs[n-1][0]
        costG = costs[n-1][1]
        costB = costs[n-1][2]
        
        for i in range(n-2,-1,-1):
            tempR = costR
            tempG = costG
            costR = costs[i][0] + min(tempG,costB)
            costG = costs[i][1] + min(tempR,costB)
            costB = costs[i][2] + min(tempG,tempR)
        return min(costR,costG,costB)
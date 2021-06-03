class Solution:
    def maxArea(self, h: int, w: int, hCuts: List[int], vCuts: List[int]) -> int:
        #edges cases
        hCuts.append(0)
        hCuts.append(h)
        
        vCuts.append(0)
        vCuts.append(w)
        
        hCuts.sort()
        vCuts.sort()
        
        maxH, maxV = 0, 0
        for i in range(1, len(hCuts)):
            maxH = max(maxH, hCuts[i] - hCuts[i - 1])
        for i in range(1, len(vCuts)):
            maxV = max(maxV, vCuts[i] - vCuts[i - 1])
        return maxH * maxV % (10**9 + 7)

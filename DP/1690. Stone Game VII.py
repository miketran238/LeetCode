class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        n = len(stones)
        presum = [0] * (n+1)
        for i in range(0,n):
            presum[i+1] = presum[i] + stones[i]

        def cal_sum(i,j):
            return presum[j+1] - presum[i]
        
        @lru_cache(2000)
        def recur(l, r, isAlice):
            if l == r : return 0 #only one stone left
            if isAlice:
                a1 = recur(l+1, r, not isAlice) + cal_sum(l+1,r)
                a2 = recur(l, r-1, not isAlice) + cal_sum(l, r-1)
                return max(a1, a2)
            else:
                a1 = recur(l+1, r, not isAlice) - cal_sum(l+1,r)
                a2 = recur(l, r-1, not isAlice) - cal_sum(l, r-1)
                return min(a1, a2)

        return recur(0, n-1, True)

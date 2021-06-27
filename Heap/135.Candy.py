class Solution:
    def candy(self, ratings: List[int]) -> int:
        res = [1] * len(ratings)
        heap = []
        for i,num in enumerate(ratings):
            heapq.heappush(heap, (num,i))
        while heap:
            curNum, idx = heapq.heappop(heap)
            rate = ratings[idx]
            left_candy, right_candy = 1,1
            if idx > 0:
                left_rate = ratings[idx-1]
                left_candy = res[idx-1] + 1 if rate > left_rate else 1
            if idx < len(res)-1:
                right_rate = ratings[idx+1] 
                right_candy = res[idx+1] + 1 if rate > right_rate else 1
            #print(left_candy, right_candy)
            res[idx] = max(left_candy, right_candy)
        return sum(res)

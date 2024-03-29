class Solution:
    def furthestBuilding(self, hs: List[int], bricks: int, ladders: int) -> int:
        pq = []
        for i in range(1, len(hs)):
            d = hs[i] - hs[i - 1]
            if d > 0:
                bricks -= d
                heappush(pq, -d)
                if bricks < 0:
                    ladders -= 1
                    bricks -= heappop(pq)
                    if bricks < 0 or ladders < 0:
                        return i - 1
        return len(hs) - 1 

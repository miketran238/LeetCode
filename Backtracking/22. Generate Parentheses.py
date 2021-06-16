class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        
        def recur(o,c, cur):
            if o == c == n:
                res.append(cur)
            if o < n:
                cur += "("
                recur(o+1, c, cur)
                cur = cur[:-1]
            if c < o and c < n:
                cur += ")"
                recur(o, c+1, cur)
                cur = cur[:-1]
        
        recur(0,0, "")
        return res

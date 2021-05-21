class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        res = []
        for w in words:
            if len(w) != len(pattern):
                continue
            map1, map2 = defaultdict(), defaultdict()
            check = True
            for i in range(len(w)):
                c1, c2 = w[i], pattern[i]
                
                if c1 not in map1:
                    map1[c1] = c2
                elif map1[c1] != c2:
                    check = False
                    break
                    
                if c2 not in map2:
                    map2[c2] = c1
                elif map2[c2] != c1:
                    check = False
                    break
            if check:
                res.append(w)
        return res

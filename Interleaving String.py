class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if ( len(s3) != len(s1) + len(s2) ) : return False
        dp = [[False for i in range(len(s2) + 1)] for j in range(len(s1) + 1)]
        #dp[i][j] = can make s3[0:i+j] by interleaving s1[i] and s2[j]
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if i == 0 and j == 0:
                    dp[i][j] = True
                elif i == 0:
                    dp[i][j] = dp[i][j-1] and s3[i+j-1] == s2[j-1]
                elif j == 0:
                    dp[i][j] = dp[i-1][j] and s3[i+j-1] == s1[i-1]
                else:
                    dp[i][j] = (dp[i][j-1] and s3[i+j-1] == s2[j-1]) or (dp[i-1][j] and s3[i+j-1] == s1[i-1])
        return dp[-1][-1]

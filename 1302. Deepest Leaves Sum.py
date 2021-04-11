# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: TreeNode) -> int:
        levelSum = defaultdict(int)
        self.max = 1
        self.dfs(root, 1, levelSum)
        return levelSum[self.max]
        
    def dfs(self, node, level, levelSum):
        if not node:
            return
        levelSum[level] += node.val
        self.max = max(self.max, level)
        self.dfs(node.left, level + 1, levelSum)
        self.dfs(node.right, level + 1, levelSum)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        st = []
        def recur(cur):
            if not cur:
                return
            recur(cur.left)
            st.append(cur.val)
            recur(cur.right)
            
        recur(root)
        
        def buildTree(l, r):
            if l > r:
                return
            m = (l + r)//2
            newRoot = TreeNode(st[m])
            newRoot.left = buildTree(l, m-1)
            newRoot.right = buildTree(m+1, r)
            return newRoot
        
        return buildTree(0, len(st)-1)
        
        
            
            

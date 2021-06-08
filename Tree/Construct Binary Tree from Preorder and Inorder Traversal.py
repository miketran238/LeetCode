# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        order = 0
        for i in range(0, len(inorder)):
            if inorder[i] == preorder[0]:
                order = i
                break
        #print(preorder, inorder)
        root.left = self.buildTree(preorder[1:order+1], inorder[:order])
        root.right = self.buildTree(preorder[order+1:], inorder[order+1:])
        return root

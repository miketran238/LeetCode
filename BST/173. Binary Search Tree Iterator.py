# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.serialize = []
        self.curPointer = -1
        def recur(cur):
            if not cur:
                return
            recur(cur.left)
            self.serialize.append(cur.val)
            recur(cur.right)
            
        #print(self.serialize)
        recur(root)
            
    def next(self) -> int:
        self.curPointer += 1
        return self.serialize[self.curPointer]

    def hasNext(self) -> bool:
        return self.curPointer < len(self.serialize)-1

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

class TrieNode:
    def __init__(self):
        self.child = {}
        self.isLeaf = False
        
class WordDictionary:
    
    def __init__(self):
        self.root = TrieNode()
        
    def addWord(self, word: str) -> None:
        node = self.root
        for w in word:
            if not w in node.child:
                node.child[w] = TrieNode()
            node = node.child[w]
        node.isLeaf = True

    def search(self, word: str) -> bool:
        def dfs(root, idx):
            #print(root.child.keys(), idx)
            if idx == len(word):
                #print('here')
                return root.isLeaf
            if word[idx] == '.':
                for c in root.child.values():
                    if dfs(c, idx+1):
                        return True
                return False
            if word[idx] not in root.child: 
                return False
            root = root.child[word[idx]]
            return dfs(root, idx+1)
            
        return dfs(self.root, 0)

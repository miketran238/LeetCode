class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length-1;
        int round = 0;
        for( int i = round; i + round <= n-1; i++ ) {
            for( int j = round; j + round <= n-1; j++ ) {
                swap(mat, i, j, j, n-i);
                swap(mat, i, j, n-i, n-j);
                swap(mat, i, j, n-j, i);
            }
            round++;
        }
    }
    
    public void swap(int[][] mat, int xa, int ya, int xb, int yb) {
        int temp = mat[xa][ya];
        mat[xa][ya] = mat[xb][yb];
        mat[xb][yb] = temp;
    }    
}

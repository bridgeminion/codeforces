public class p5883 {

    public boolean works1 (char[][] board, String word, int n, int m, int r, int c){
        for (int i=0; i < word.length(); i++){
            char cur = word.charAt(i);
            int row = r;
            int col = c+i;
            if (row < 0 || row >= n || col < 0 || col >= m || !(board[row][col] == ' ' || board[row][col] == cur)){
                return false;
            }
        }
        if (c > 0 && board[r][c-1] != '#'){
            return false;
        }
        if (c+word.length() < m && board[r][c+word.length()] != '#'){
            return false;
        }
        return true;
    }

    public boolean works2 (char[][] board, String word, int n, int m, int r, int c){
        for (int i=0; i < word.length(); i++){
            char cur = word.charAt(word.length()-i-1);
            int row = r;
            int col = c+i;
            if (row < 0 || row >= n || col < 0 || col >= m || !(board[row][col] == ' ' || board[row][col] == cur)){
                return false;
            }
        }
        if (c > 0 && board[r][c-1] != '#'){
            return false;
        }
        if (c+word.length() < m && board[r][c+word.length()] != '#'){
            return false;
        }
        return true;
    }

    public boolean works3 (char[][] board, String word, int n, int m, int r, int c){
        for (int i=0; i < word.length(); i++){
            char cur = word.charAt(i);
            int row = r+i;
            int col = c;
            if (row < 0 || row >= n || col < 0 || col >= m || !(board[row][col] == ' ' || board[row][col] == cur)){
                return false;
            }
        }
        if (r > 0 && board[r-1][c] != '#'){
            return false;
        }
        if (r+word.length() < n && board[r+word.length()][c] != '#'){
            return false;
        }
        return true;
    }

    public boolean works4 (char[][] board, String word, int n, int m, int r, int c){
        for (int i=0; i < word.length(); i++){
            char cur = word.charAt(word.length()-i-1);
            int row = r+i;
            int col = c;
            if (row < 0 || row >= n || col < 0 || col >= m || !(board[row][col] == ' ' || board[row][col] == cur)){
                return false;
            }
        }
        if (r > 0 && board[r-1][c] != '#'){
            return false;
        }
        if (r+word.length() < n && board[r+word.length()][c] != '#'){
            return false;
        }
        return true;
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        // horizontal
        for (int i=0; i < n; i++){
            for (int j=0; j < m-word.length()+1; j++){
                if (works1 (board, word, n, m, i, j) || works2 (board, word, n, m, i, j)){
                    return true;
                }
            }
        }
        // vertical
        for (int i=0; i < n-word.length()+1; i++){
            for (int j=0; j < m; j++){
                if (works3 (board, word, n, m, i, j) || works4 (board, word, n, m, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
}

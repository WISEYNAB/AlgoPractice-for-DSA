package Arrays;

class Solution {
    int n;
    int m;
    public int numMagicSquaresInside(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(isMagic(grid,i,j)){
                    count++;
                }
            }
        }

        return count;
    }

    boolean isMagic(int[][] grid,int i,int j){
        int rb = i + 2;
        int cb = j + 2;
        Set<Integer> dis = new HashSet<>();
        if(rb >= n || cb >= m || grid[i][j] > 9 || grid[i][j] < 1){
            return false;
        }

        int rowSum = -1;
        int prev = -1;
        for(int k = j; k <= cb;k++){
            int curr = 0;
            for(int g = i;g <= rb;g++){
                if(dis.contains(grid[g][k])){
                    return false;
                }
                dis.add(grid[g][k]);
                if(grid[g][k] > 9 || grid[g][k] < 1){
                    return false;
                }
                curr += grid[g][k];
            }
            if(rowSum == -1){
                rowSum = curr;
                continue;
            }

            if(rowSum != curr){
                return false;
            }
        }

        int colSum = -1;

        for(int k = i; k <= rb;k++){
            int curr = 0;
            for(int g = j;g <= cb;g++){
                curr += grid[k][g];
            }
            if(colSum == -1){
                colSum = curr;
                continue;
            }

            if(colSum != curr){
                return false;
            }
        }


        int diagOne = 0;

        diagOne = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];

        int diagTwo = grid[i][cb] + grid[i+1][j+1] + grid[rb][j];

        if(diagOne != diagTwo){
            return false;
        }

        return diagOne == rowSum && rowSum == colSum;
    }
}
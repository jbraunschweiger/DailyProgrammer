public class SingleSymbolSquare{
    public static void main(String[] args){
        boolean[][] grid1 = {{true,false,true,false},{true,false,false,false},{false,true,true,false},{false,false,false,false}};
        System.out.println(checkSquares1(grid1, 2));
        System.out.println(checkSquares1(grid1, 3));
        System.out.println(checkSquares1(grid1, 4));
    }
    public static boolean[][] CreateArray(int size){
        boolean[][] toReturn = new boblean[size][size];
        return toReturn;
    }
    public static boolean[][] addSize(boolean[][] oldGrid){
        int newSize = oldGrid.length +1;
        newGrid = new boolean[newSize][newSize];
        return newGrid;
    }
    public static boolean[][] fillNewSize(boolean[][] grid, int amtFilled){
        return grid;
    }
    public static boolean checkSquares(boolean[][] grid, int sideLength){
        int size = sideLength-1;
        for(int i=0;i<(grid.length - size);i++){
            for(int j=0;j<(grid.length - size);j++){
                if(grid[i][j]&&grid[i][j+size]&&grid[i+size][j]&&grid[i+size][j+size]){
                    return false;
                }
                if(!grid[i][j]&&!grid[i][j+size]&&!grid[i+size][j]&&!grid[i+size][j+size]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[] test(int[] grid, int count){
        if(count>=3){return grid;}
        grid[0]++;
        count++;
        test(grid.clone(),count);
        return test(grid.clone(),count);
    }
    public static boolean checkSquares1(boolean[][] grid, int sideLength){
        int size = sideLength-1;
        for(int i=0;i<(grid.length - size);i++){
            for(int j=0;j<(grid.length - size);j++){
                if(grid[i][j]&&grid[i][j+size]&&grid[i+size][j]&&grid[i+size][j+size]){
                    return false;
                }
                if(!grid[i][j]&&!grid[i][j+size]&&!grid[i+size][j]&&!grid[i+size][j+size]){
                    return false;
                }
            }
        }
        return true;
    }
}
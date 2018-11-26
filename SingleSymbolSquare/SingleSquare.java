public class SingleSquare{
    public boolean[][] grid;
    public boolean[][] nextGrid;
    public int size;
    public SingleSquare(){
        grid = new boolean[1][1];
        nextGrid = new boolean[2][2];
        size = 1;
    }
    public void increaseSize(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                nextGrid[i+1][j+1] = grid [i][j];
            }
        }
        int rand = (int)(Math.random()+0.5);
        boolean b;
        if(rand == 0){b =false;}
        else{b=true;}
        if(fix(0,b,b)){
            grid = nextGrid;
            size++;
            nextGrid = new boolean[size+1][size+1];
        } else {
            System.out.println("well shit");
        }
    }
    private boolean fix(int amt, boolean l, boolean r){
        if(amt > size && checkAll(subArray(amt))){
            return true;
        } else if(amt > size){
            return false;
        }
        boolean toReturn = false;
        nextGrid[amt][0] = l;
        nextGrid[0][amt]=r;
        amt++;
        if(checkAll(subArray(amt))){
            if(fix(amt,true,false)){
                toReturn = true;
            } else if (fix(amt,false,true)){
                toReturn = true;
            } else if (fix(amt,true,true)){
                toReturn = true;
            } else if (fix(amt,false,false)){
                toReturn = true;
            }
        }
        return toReturn;
    }
    private boolean[][] subArray(int s){
        boolean[][] sub = new boolean[s][s];
        for(int i = 0; i<s; i++){
            for(int j = 0; j<s; j++){
                sub[i][j] = nextGrid[i][j];
            }
        }
        return sub;
    }
    private boolean checkAll(boolean[][] grid){
        for(int i = 2; i<=grid.length; i++){
            if(!checkSquares(grid,i)){
                return false;
            }
        }
        return true;
    }
    private boolean checkSquares(boolean[][] grid, int sideLength){
        int s = sideLength-1;
        for(int i=0;i<(grid.length - s);i++){
            for(int j=0;j<(grid.length - s);j++){
                if(grid[i][j]&&grid[i][j+s]&&grid[i+s][j]&&grid[i+s][j+s]){
                    return false;
                }
                if(!grid[i][j]&&!grid[i][j+s]&&!grid[i+s][j]&&!grid[i+s][j+s]){
                    return false;
                }
            }
        }
        return true;
    }
    public String toString(){
        String s = "";
        for(boolean[] r: grid){
            for(boolean c: r){
                String b;
                if(c){b="X";}
                else{b="O";}
                s+=""+b+" ";
            }
            s+="\n";
        }
        return s;
    }
    public static void main(String[] args){
        System.out.println("hello world");
        SingleSquare square1 = new SingleSquare();
        System.out.println(square1);
        square1.increaseSize();
        System.out.println(square1);
        square1.increaseSize();
        System.out.println(square1);
        square1.increaseSize();
        System.out.println(square1);
        square1.increaseSize();
        System.out.println(square1);
        square1.increaseSize();
        System.out.println(square1);
    }
}
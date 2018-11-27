public class UpArrow{
    public static void main(String[] args){
        //System.out.print(upArrow(5,4,5));
        //System.out.print(upArrow(7,5,3));
        System.out.println(upArrow(-1,3,3));
        System.out.println(upArrow(1,1,0));
        System.out.println(upArrow(1,2,0));
        //System.out.print(upArrow(12,10,25));
    }
    /*
     * int a is the left operand
     * int num is the number of up-arrow operaters
     * int b is the right operand
     */
    public static int upArrow(int a, int num, int b){
        if(num <= 1){
            return (int)(Math.pow(a, b));
        }
        int toReturn = a;
        num--;
        for(int i  = 0; i<(b-1);i++){
            toReturn = upArrow(a,num,toReturn);
        }
        return toReturn;
    }
}
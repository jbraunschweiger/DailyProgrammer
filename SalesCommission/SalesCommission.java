import java.util.*;
import java.io.*;
/**
 * Write a description of class SalesCommission here.
 *
 * @author Jakob Braunschweiger
 * @version 11/24/18
 */
public class SalesCommission
{
    public static void main(String[] args){
        int[][] testArray1 = {{120,145},{243,265}};
        int[][] testArray2 = {{130,59},{143,198}};
        printArray(calculateCommission(testArray1, testArray2));
    }
    public static int[] calculateCommission(int[][] revenues, int[][] expenses){
        if(revenues.length != expenses.length || revenues[0].length != expenses[0].length){
            throw new IllegalArgumentException("arrays must be of equal size");
        }
        int[] commission = new int[revenues[0].length];
        for(int col = 0; col < revenues[0].length; col++){
            int totalRev = 0;
            int totalExp = 0;
            for(int row = 0; row < revenues.length; row++){
                totalRev += revenues[row][col];
                totalExp += expenses[row][col];
            }
            int profit = totalRev - totalExp;
            if(profit >= 0){
                commission[col] = (int)(profit*0.062);
            }
        }
        return commission;
    }
    public static void printArray(int[] input){
        System.out.println();
        for(int i = 0; i < input.length; i++){
            System.out.print("" + input[i] + "\t");
        }
        System.out.println();
    }
}

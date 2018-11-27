public class Derrangement{
    public static void main(String[] args){
        System.out.println(derrangemnet(5));
        System.out.println(derrangemnet(6));
        System.out.println(derrangemnet(9));
        System.out.println(derrangemnet(14));
    }
    public static long derrangemnet(long n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 0;
        }
        return (n-1)*(derrangemnet(n-1)+derrangemnet(n-2));
    }
}
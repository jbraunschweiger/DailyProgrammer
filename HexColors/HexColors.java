import java.util.LinkedList;

public class HexColors{
    public static void main(String[] args){
        System.out.println(rgbtoHex(5,15,32));
        String[] colors = {"#000000","#778899"};
        String s = blend(colors);
        System.out.println(s);
    }
    public static String rgbtoHex(int r, int g, int b){
        return "#" + String.format("%02x", r)+String.format("%02x", g)+String.format("%02x", b);
    }
    public static String blend(String[] values){
        int[] rgb = new int[3];
        for(String v: values){
            System.out.println(Integer.parseInt(v.substring(1,3), 16));
            rgb[0] += Integer.parseInt(v.substring(1,3), 16);
            rgb[1] += Integer.parseInt(v.substring(3,5), 16);
            rgb[2] += Integer.parseInt(v.substring(5,7), 16);
        }
        System.out.println();
        for(int i = 0; i < rgb.length; i++){
            rgb[i] = (rgb[i]/values.length);
        }
        return rgbtoHex(rgb[0],rgb[1],rgb[2]);
    }
}
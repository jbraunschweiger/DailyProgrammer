import java.util.*;
import java.io.*;
import java.net.*;
/**
 * Write a description of class WordFunnel here.
 *
 * @author Jakob Braunschweiger
 * @version 11/25/18
 */
public class WordFunnel
{
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt");
        Scanner s = new Scanner(url.openStream());
        
        TreeSet<String> words = new TreeSet<String>();
        String word = "";
        while(!(word = s.nextLine()).equals("zyzzyvas")){
            words.add(word);
        }
        System.out.println("gnash \t=> " + wordFunnel("gnash",words));
        System.out.println("princesses \t=> " + wordFunnel("princesses",words));
        System.out.println("turntables \t=> " + wordFunnel("turntables",words));
        System.out.println("implosive \t=> " + wordFunnel("implosive",words));
        System.out.println("programmer \t=> " + wordFunnel("programmer",words));
        
        System.out.println();
        int length  = 8;
        LinkedList<String> found  = findFunnel(length,words);
        System.out.println("Word(s) with funnel length " + length + ":");
        for(String f: found){
            System.out.println(f);
        }
    }
    public static int wordFunnel(String word, TreeSet<String> words){
        if(words.contains(word)){
            //String newWord = word.substring(1,word.length());
            int maxFunnel = 0;
            for(int i = 0; i < word.length(); i++){
                String newWord = word.substring(0,i) + word.substring(i+1,word.length());
                int newFunnel = wordFunnel(newWord,words);
                if(newFunnel > maxFunnel){
                    maxFunnel = newFunnel;
                }
            }
            return 1 + maxFunnel;
        } else {
            return 0;
        }
    }
    public static void printFunnel(String word){
        if(word.length()>0){
            String newWord = word.substring(1,word.length());
            System.out.println(word);
            printFunnel(newWord);
        } else {
            return;
        }
    }
    /*
     * optional bonus 1
     * take in target funnel length to search for and set of words to search through
     * return a list of all words with target funnel length in the word set
     */
    public static LinkedList<String> findFunnel(int length, TreeSet<String> words){
        LinkedList<String> output = new LinkedList<String>();
        for(String word: words){
            if(wordFunnel(word,words) == length){
                output.add(word);
            }
        }
        return output;
    }
}

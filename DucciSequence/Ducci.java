import java.util.LinkedList;

public class Ducci{
    static int maxRecursion = 3500;
    int[] tuple;
    int[] nextTuple;
    LinkedList<int[]> previousTuples;
    LinkedList<int[]> loop;
    String solution;
    public Ducci(int[] initTuple){
        this.tuple = initTuple.clone();
        this.nextTuple = new int[initTuple.length];
        this.solution = "unsolved";
        this.previousTuples = new LinkedList<int[]>();
        this.loop = new LinkedList<int[]>();
    }
    public void solve(int count){
        boolean allZeros = true;
        for(int i = 0; i<tuple.length; i++){
            if(i == tuple.length -1){
                this.nextTuple[i] = Math.abs(tuple[i]-tuple[0]);
            } else{
                this.nextTuple[i] = Math.abs(tuple[i]-tuple[i+1]);
            }
            if(!(this.nextTuple[i] == 0)){
                allZeros = false;
            }
        }
        this.tuple = this.nextTuple.clone();
        this.previousTuples.add(this.nextTuple.clone());
        //System.out.println(this.toString());
        if(allZeros){
            this.solution = "solved";
            return;
        }
        if(this.previousTuples.contains(this.tuple)){
            loop.add(this.tuple.clone());
        } else {
            loop.clear();
        }
        LinkedList<int[]> shortPrevious = new LinkedList<int[]>();
        shortPrevious.addAll(this.previousTuples);
        while(shortPrevious.size()<this.loop.size()){
            shortPrevious.removeFirst();
        }
        if(shortPrevious.equals(loop)&&loop.size()>0){
            this.solution = "loop";
            return;
        }
        if(count>=Ducci.maxRecursion){
            this.solution = "impossible";
            return;
        }
        count++;
        System.out.println(this.previousTuples.size());
        this.solve(count);
    }
    public String toString(){
        String toReturn = "";
        for(int n: this.tuple){
            toReturn += (n + " ");
        }
        return toReturn;
    }
    public static void main(String[] args){
        int[] t1 = {1, 5, 7, 9, 9};
        int[] t2 = {1, 2, 1, 2, 1, 0};
        int[] t3 = {10, 12, 41, 62, 31, 50};
        int[] t4 = {10, 12, 41, 62, 31};
        Ducci d1 = new Ducci(t1);
        Ducci d2 = new Ducci(t2);
        Ducci d3 = new Ducci(t3);
        Ducci d4 = new Ducci(t4);
        d1.solve(0);
        d2.solve(1);
        d3.solve(2);
        d4.solve(3);
        System.out.println(d1.solution);
        System.out.println(d1.previousTuples.size() +1);
        System.out.println(d2.solution);
        System.out.println(d2.previousTuples.size() +1);
        System.out.println(d3.solution);
        System.out.println(d3.previousTuples.size() +1);
        System.out.println(d4.solution);
        System.out.println(d4.previousTuples.size() +1);
    }
}
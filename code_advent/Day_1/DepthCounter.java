package code_advent.Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DepthCounter {
    private Scanner sc;
    private int count;

    public DepthCounter(File file) throws FileNotFoundException{
        sc = new Scanner(file);
        count = 0;
    }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("code_advent/input.txt");
        DepthCounter d = new DepthCounter(file);
        System.out.println(d.countInc());
    }
    
    public int countInc(){
        int first = nextInt();
        int second = nextInt();
        int third = nextInt();
        int prevSum = 0;
        int nextSum = 0;
        
        while(sc.hasNextLine()){
            int fourth = nextInt();
            prevSum = first + second + third;
            nextSum = second + third + fourth;
            
            if(nextSum > prevSum){
                count++;
            }
            first = second;
            second = third;
            third = fourth;
        }
        return count;
    }

    public int nextInt(){
        return toInt(sc.nextLine());
    }

    public int toInt(String s){
        return Integer.parseInt(s);
    }
}

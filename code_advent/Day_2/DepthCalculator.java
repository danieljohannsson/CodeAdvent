package code_advent.Day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DepthCalculator {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("code_advent/Day_2/input.txt");
        Scanner sc = new Scanner(file);

        int x = 0;
        int y = 0;
        int aim = 0;

        while(sc.hasNextLine()){
            String dir = sc.next();
            int size = sc.nextInt();

            switch(dir){
                case "forward":
                    x += size;
                    y += aim * size;
                break;

                case "down":
                    aim += size;
                break;

                case "up":
                    aim -= size;
                break;
            }
        }
        System.out.println("x:" + x + " y:" + y);
    }
}
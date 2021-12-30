package code_advent.Day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LanternSimulation {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("code_advent/Day_6/input.txt"));
        String[] input = sc.next().split(",");
        int[] lanterns = new int[input.length];

        for(int i = 0; i < lanterns.length; i++){
            lanterns[i] = toInt(input[i]);
        }

        int PART1 = 80;
        int PART2 = 256;
        
        for(int i = 0; i <= PART1; i++){

            int elements = lanterns.length;
            int zeroCount = 0;
            for(int j = 0; j < elements; j++){
                int nbr = lanterns[j];
                if(nbr != 0){
                    nbr--;
                    lanterns[j] = nbr;
                } else {
                    zeroCount++;
                    lanterns[j] = 6;
                }
            }
            int[] copy = new int[lanterns.length + zeroCount];
            for(int j = 0; j < elements; j++){
                copy[j] = lanterns[j];
            }
            for(int j = elements; j < elements + zeroCount; j++){
                copy[j] = 8;
            }
            lanterns = copy;
            System.out.println("Day " + i + ": " + elements);
        }
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}

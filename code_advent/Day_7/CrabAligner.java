package code_advent.Day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CrabAligner {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("code_advent/Day_7/input.txt"));
        String[] crabs = sc.next().split(",");
        int[] copy = new int[crabs.length];
        for(int i = 0; i < crabs.length; i++){
            copy[i] = Integer.parseInt(crabs[i]);
        }
        Arrays.sort(copy);
        System.out.println(copy[0]);
        System.out.println(copy[copy.length-1]);
        int min = copy[0];
        int max = copy[copy.length-1];

        HashMap<String, Integer> count = new HashMap<>();
        for(int i = 0; i < max; i++){
            int fuel = 0;
            for(int nbr: copy){
                //fuel += Math.abs(i - nbr); PART 1
                fuel += sigma(Math.abs(i-nbr));
            }
            count.put(Integer.toString(i), fuel);
        }
        int minFuel =  count.values().stream().min((e1, e2) -> e1.compareTo(e2)).get();
        System.out.println(minFuel);
    }
    
    public static int sigma(int nbr){
        if(nbr == 0){
            return nbr;
        } else {
        return nbr + sigma(nbr - 1);
        }
    }
}

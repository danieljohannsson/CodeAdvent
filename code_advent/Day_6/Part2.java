package code_advent.Day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("code_advent/Day_6/input.txt"));
        String[] input = sc.next().split(",");
        Map<String, Long> count = new HashMap<>();
        count.put("0", 0L);
        count.put("1", 0L);
        count.put("2", 0L);
        count.put("3", 0L);
        count.put("4", 0L);
        count.put("5", 0L);
        count.put("6", 0L);
        count.put("7", 0L);
        count.put("8", 0L);

        for(String s: input){
            switch(s){
                case "0": count.put("0", count.get("0") + 1);
                    break;
                
                case "1": count.put("1", count.get("1") + 1);
                    break;

                case "2": count.put("2", count.get("2") + 1);
                    break;

                case "3": count.put("3", count.get("3") + 1);
                    break;

                case "4": count.put("4", count.get("4") + 1);
                    break;

                case "5": count.put("5", count.get("5") + 1);
                    break;
                
                case "6": count.put("6", count.get("6") + 1);
                    break;
                
                default:
                break;
            }
        }

        int PART1 = 80;
        int PART2 = 256;
        
        for(int i = 0; i < PART2; i++){
            Long zero = count.get("1");
            Long one = count.get("2");
            Long two = count.get("3");
            Long three = count.get("4");
            Long four = count.get("5");
            Long five = count.get("6");
            Long six = count.get("7") + count.get("0");
            Long seven = count.get("8");
            Long eight = count.get("0");
            count.put("0", zero);
            count.put("1", one);
            count.put("2", two);
            count.put("3", three);
            count.put("4", four);
            count.put("5", five);
            count.put("6", six);
            count.put("7", seven);
            count.put("8", eight);
        }
        long sum = 0;
        for(long i: count.values()){
            sum += i;
        }
        System.out.println(count);
        System.out.println(sum);
    }
}

package code_advent.Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PowerConsumption {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("code_advent/Day_3/input.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();

        while(sc.hasNext()){
            list.add(sc.next());
        }
        String epsilon = "";
        String gamma = "";
        for(int i = 0; i < list.get(0).length(); i++) {
            int one = 0;
            int zero = 0;
            
            for(String s: list){
                char nbr = s.charAt(i);
                if(nbr == '1'){
                    one++;
                } else {
                    zero++;
                }
            }

            if(zero < one){
                gamma += "1";
                epsilon += "0";
            } else {
                gamma += "0";
                epsilon += "1";
            }
        }
        sc.close();
        System.out.println("gamma:" + gamma + " epsilon:" + epsilon);
        System.out.println("gamma in decimal: " + Integer.parseInt(gamma, 2) + " epsilon in decimal: " + Integer.parseInt(epsilon, 2));
        System.out.println("with product: " + Integer.parseInt(gamma, 2)*Integer.parseInt(epsilon, 2));
    }
}

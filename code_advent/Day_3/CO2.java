package code_advent.Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CO2 {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("code_advent/Day_3/input.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        
        while(sc.hasNext()){
            list.add(sc.next());
        }
        ArrayList<String> co2 = new ArrayList<>(list);
        
        for(int i = 0; i < list.get(0).length(); i++) {
            int one = 0;
            int zero = 0;

            ArrayList<String> copy = new ArrayList<>(co2);
            
            for(String s: copy){
                char nbr = s.charAt(i);
                if(nbr == '1'){
                    one++;
                } else {
                    zero++;
                }
            }

            if(zero <= one){
                for(String s: copy){
                    if(s.charAt(i) == '1' && co2.size() > 1){
                        co2.remove(s);
                    }
                }
            } else {
                for(String s: copy){
                    if(s.charAt(i) == '0' && co2.size() > 1){
                        co2.remove(s);
                    }
                }
            }
        }
        sc.close();
        System.out.println("CO2: " + co2 + " " + Integer.parseInt(co2.get(0), 2));
    }
}
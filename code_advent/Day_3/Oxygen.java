package code_advent.Day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oxygen {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("code_advent/Day_3/input.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        
        while(sc.hasNext()){
            list.add(sc.next());
        }
        ArrayList<String> oxyG = new ArrayList<>(list);
        
        for(int i = 0; i < list.get(0).length(); i++) {
            int one = 0;
            int zero = 0;

            ArrayList<String> copy = new ArrayList<>(oxyG);
            
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
                    if(s.charAt(i) == '0' && oxyG.size() > 1){
                        oxyG.remove(s);
                    }
                }
            } else {
                for(String s: copy){
                    if(s.charAt(i) == '1' && oxyG.size() > 1){
                        oxyG.remove(s);
                    }
                }
            }
        }
        sc.close();
        System.out.println("Oxygen: " + oxyG + " " + Integer.parseInt(oxyG.get(0), 2));


    }
}

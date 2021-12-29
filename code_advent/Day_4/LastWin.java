package code_advent.Day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LastWin {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("code_advent/Day_4/input.txt"));
        List<String> nbrs = new ArrayList<>(Arrays.asList(sc.next().split(",")));
        System.out.println(nbrs);

        List<List<List<String>>> bingo = new ArrayList<>();

        while(sc.hasNext()){
            List<List<String>> board = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                List<String> row = new ArrayList<>();
                for(int j = 0; j < 5; j++){
                    if(sc.hasNext()) row.add(sc.next());
                }
                board.add(row);
            }
            bingo.add(board);
        }
        boolean found = false;
        int count = 0;
        List<List<List<String>>> loser = new ArrayList<>(bingo);

        while(!found){

                for(List<List<String>> board: bingo){
                    
                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++){
                            if(board.get(i).get(j).equals(nbrs.get(count))){
                                board.get(i).set(j, "X");
                                if(isRowBingo(board.get(i)) || isColBingo(board)){
                                    loser.remove(board);
                                    System.out.println(nbrs.get(count));
                                }
                            }
                        }
                    }
                }
            if(loser.size() == 1) found = true;    
            if(!found) count++;
        }
        System.out.println(nbrs.get(count));
        System.out.println(loser);
    }

    public static boolean isRowBingo(List<String> arr){
        for(String s: arr){
            if(!s.equals("X")) return false;
        }
        return true;
    }

    public static boolean isColBingo(List<List<String>> matrix){
        for(int i = 0; i < 5; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                list.add(matrix.get(j).get(i));
            }
            if(isRowBingo(list)) return true;
        }
        return false;
    }
}

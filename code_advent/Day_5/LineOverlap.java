package code_advent.Day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineOverlap {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("code_advent/Day_5/input.txt"));
        
        int[][] board = new int[1000][1000];
        List<Line> lines = new ArrayList<>();

        for(int[] i:board){
            Arrays.fill(i, 0);
        }
        while(sc.hasNext()){
            String[] point1 = sc.next().split(",");
            sc.next();
            String[] point2 = sc.next().split(",");
            lines.add(new Line(toInt(point1[0]), toInt(point1[1]), toInt(point2[0]), toInt(point2[1])));
        }
        
        for(Line line: lines){
            if(line.getX1() == line.getX2()){
                if((line.getY2() - line.getY1()) < 0){
                    for(int j = line.getY1(); j >= line.getY2(); j--){
                        board[line.getX1()][j]++;
                    }
                } else {
                    for(int j = line.getY1(); j <= line.getY2(); j++){
                        board[line.getX1()][j]++;
                    }
                }
            } else if(line.getY1() == line.getY2()){
                if((line.getX2() - line.getX1()) < 0){
                    for(int j = line.getX1(); j >= line.getX2(); j--){
                        board[j][line.getY1()]++;
                    }
                } else {
                    for(int j = line.getX1(); j <= line.getX2(); j++){
                        board[j][line.getY1()]++;
                    }
                }
            }
        }

        int count = 0;
        for(int[] arr: board){
            for(int i: arr){
                if(i > 1) count++;
            }
        }
        System.out.println(count);
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}

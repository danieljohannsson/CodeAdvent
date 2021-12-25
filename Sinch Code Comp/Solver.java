package com.arkad.competition.solve;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface Solver {
	public void setup(int width, int height);
	public int[][] solve(int[][] matrix);
	public enum Direction {
		EAST(0),
		NORTH(1),
		WEST(2),
		SOUTH(3);

		private final int dir;

		private Direction(int dir) {
			this.dir = dir;
		}

		public int toInt() {
			return this.dir;
		}

		public Direction opposite() {
			return Direction.values()[(this.dir+2) % 4];
		}
	}

    public static void printSolution(int[][] solution) {
        System.out.println(String.join("\n", Arrays.stream(solution).map(a -> "[" + a[0] + "," + a[1] + "] " + Direction.values()[a[2]]).toArray(String[]::new)));
    }

	public static void printGrid(int[][] solution, int[][] matrix) {
        printGrid(solution, matrix, false);
    }
    
    //The following code is not meant to be read or understood
    //Set c to true for compatability mode
	public static void printGrid(int[][] solution, int[][] matrix, boolean c) {
        String RESET      = "\u001B[0m";
        String WHITE      = c ? "\u001B[30m" : "\0\0\0\0\0\0\u001B[37m";
        String RED        = c ? "\u001B[31m" : "\0\0\0\0\0\0\u001B[31m";
        String YELLOW_B   = c ? "\u001B[43m" : "\0\u001B[48;5;58m";
        String GREEN_B1   = c ? "\u001B[42m" : "\0\u001B[48;5;22m";
        String GREEN_B2   = c ? "\u001B[46m" : "\0\u001B[48;5;28m";
        String BLUE_B1    = c ? "\u001B[44m" : "\0\u001B[48;5;20m";
        String BLUE_B2    = c ? "\u001B[44m" : "\0\u001B[48;5;27m";
        String MAGENTA_B1 = c ? "\u001B[45m" : "\0\u001B[48;5;57m";
        String MAGENTA_B2 = c ? "\u001B[45m" : "\0\u001B[48;5;63m";
        String GREY       = c ? "\u001B[37m" : "\u001B[38;5;213m";
        int cl = c ? 5 : 11;

        String FENCE_LU = c ? " ." : " ╭";
        String FENCE_RU = c ? ". " : "╮ ";
        String FENCE_LL = c ? " '" : " ╰";
        String FENCE_RL = c ? "' " : "╯ ";
        String FENCE_H  = c ? "--" : "──";
        String FENCE_VL = c ? " |" : " │";
        String FENCE_VR = c ? "| " : "│ ";
        String FENCE_CH = c ? "++" : "┼┼";
        
        String FENCE_CTE = c ? ".." : "┬┬";
        String FENCE_CBE = c ? "''" : "┴┴";
        String FENCE_CL  = c ? "<I" : "⊏I";
        String FENCE_CLE = c ? "=I" : "ﾆI";
        String FENCE_CR  = c ? "I>" : "Iｺ";
        String FENCE_CRE = c ? "I=" : "Iﾆ";

        String STONE   = c ? "()" : "Ո∩";
        String TREE_RE = c ? "=>" : "ﾆｺ";
        String TREE_LE = c ? "<=" : "⊏ﾆ";
        String TREE_TE = c ? "TT" : "┌┐";
        String TREE_BE = c ? "LJ" : "└┘";
        String TREE_HO = c ? "==" : "ﾆﾆ";
        String TREE_VE = c ? "||" : "││";
        String TREE_CH = c ? "##" : "╪╪";
        String TREE_CV = c ? "{}" : "╡╞";
        String TREE_CL = c ? "<<" : "⍃⍃";
        String TREE_CR = c ? ">>" : "⍄⍄";
        String TREE_CT = c ? "/\\" : "⍁⍂";
        String TREE_CB = c ? "\\/" : "⍂⍁";
        String TREE_DI = c ? "D#" : "✥⚠";

		if(matrix.length < 1) return;
		int width = matrix.length, height = matrix[0].length;
        String[][] map = new String[width+2][height+2];
        for (int y = 1; y < map.length-1; y++) {
            for (int x = 1; x < map[y].length-1; x++) {
                String c2 = matrix[y-1][x-1] > 1 ? YELLOW_B : 
                ((x+y)%2 == 0 ? GREEN_B1 : GREEN_B2);
                map[y][x] = (matrix[y-1][x-1] == 1 ? GREY : WHITE) + c2 + "  ";
            }
        }
        for(int x = 1; x < map[0].length-1; x++) {
            map[0][x] = WHITE + GREEN_B1 + FENCE_H;
            map[map.length-1][x] = WHITE + GREEN_B1 + FENCE_H;
        }
        for (int y = 1; y < map.length-1; y++) {
            map[y][0] = WHITE + GREEN_B1 + FENCE_VL;
            map[y][map[0].length-1] = WHITE + GREEN_B1 + FENCE_VR;
        }
        map[0][0] = WHITE + GREEN_B1 + FENCE_LU;
        map[0][map[0].length-1] = WHITE + GREEN_B1 + FENCE_RU;
        map[map.length-1][0] = WHITE + GREEN_B1 + FENCE_LL;
        map[map.length-1][map[0].length-1] = WHITE + GREEN_B1 + FENCE_RL;

        Set<Cord> used = new HashSet<Cord>();

        for (int[] i : solution) {
            Cord cord = new Cord(i[0],i[1]);
            int dir = i[2];
            if(used.contains(cord)) {
                used.add(cord);
                map[cord.y+1][cord.x+1] = map[cord.y+1][cord.x+1].substring(0,cl) + ((cord.y+cord.x) % 2 == 0 ? MAGENTA_B1 : MAGENTA_B2) + map[cord.y+1][cord.x+1].substring(2*cl);
                continue;
            }
            used.add(cord);
            int size = matrix[cord.y][cord.x];
            int xi = 0, yi = 0;
            switch(dir){
                case 0:
                    xi = 1;
                    break;
                case 1:
                    yi = -1;
                    break;
                case 2:
                    xi = -1;
                    break;
                case 3:
                    yi = 1;
                    break;
            }

            String MIDDLE = (dir % 2 == 1) ? TREE_VE : TREE_HO;
            String MIDDLE_OPPOSITE = (dir % 2 == 0) ? TREE_VE : TREE_HO;
            String COLLISION = (dir % 2 == 1) ? TREE_CH : TREE_CV;
            String COLLISION_OPPOSITE = (dir % 2 == 0) ? TREE_CH : TREE_CV;

            String END = (dir % 2 == 1) ? (
                dir < 2 ? TREE_BE : TREE_TE
            ) : (
                dir < 2 ? TREE_LE : TREE_RE
            );
            String END_OPPOSITE = (dir % 2 == 0) ? (
                dir < 2 ? TREE_RE : TREE_LE
            ) : (
                dir < 2 ? TREE_TE : TREE_BE
            );
            String LINCOL = (dir % 2 == 0) ? (
                dir < 2 ? TREE_CR : TREE_CL
            ) : (
                dir < 2 ? TREE_CT : TREE_CB
            );
            String LINCOL_OPPOSITE = (dir % 2 == 1) ? (
                dir < 2 ? TREE_CB : TREE_CT
            ) : (
                dir < 2 ? TREE_CR : TREE_CL
            );
            if(size <= 1) {
                map[cord.y+1][cord.x+1] = RED + ((i[0]+i[1]) % 2 == 0 ? BLUE_B1 : BLUE_B2) + map[cord.y+1][cord.x+1].substring(2*cl);
            } else if(dir < 0 || dir > 3) {
                map[cord.y+1][cord.x+1] = RED + map[cord.y+1][cord.x+1].substring(cl,2*cl) + TREE_DI;
            } else {
                for (int j = 0; j < size; j++) {
                    int Y = cord.y+j*yi+1, X = cord.x+j*xi+1;

                    if(Y < 0 || Y >= height+2 || X < 0 || X >= width+2) {
                        break;
                    }

                    String CFG = map[Y][X].substring(0,cl); //foreground
                    String CBG = map[Y][X].substring(cl,2*cl); //background
                    String CHAR = map[Y][X].substring(2*cl); //character
                    
                    if(Y == 0 || Y == height+1 || X == 0 || X == width+1) { //fence collision
                        CFG = RED;
                        if(CHAR.equals(FENCE_VR)) {
                            CHAR = j == size-1 ? FENCE_CRE : FENCE_CR;
                        } else if(CHAR.equals(FENCE_VL)) {
                            CHAR = j == size-1 ? FENCE_CLE : FENCE_CL;
                        } else {
                            if(j == size-1) {
                                CHAR = Y == 0 ? FENCE_CTE : FENCE_CBE;
                            } else {
                                CHAR = FENCE_CH;
                            }
                        }
                    } else if(!CHAR.equals("  ")) { //tree collision
                        CFG = RED;
                        if(size -1 == 0) CHAR = STONE;
                        else if(CHAR.equals(MIDDLE)) CHAR = LINCOL;
                        else if(CHAR.equals(MIDDLE_OPPOSITE)) CHAR = COLLISION;
                        else if(CHAR.equals(COLLISION_OPPOSITE)) CHAR = COLLISION;
                        else if(CHAR.equals(END)) CHAR = LINCOL;
                        else if(CHAR.equals(END_OPPOSITE)) CHAR = LINCOL_OPPOSITE;
                    } else { //no collision
                        if(j == 0) {
                            CHAR = (j==size-1) ? STONE : END;
                        } else {
                            CFG = CBG.equals(YELLOW_B) ? RED : CFG; //falling through a tree
                            if(j == size-1)
                                CHAR = END_OPPOSITE;
                            else CHAR = MIDDLE;
                        }
                    }
                    map[Y][X] = CFG + CBG + CHAR;
                }
            }
        }

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if(y > 0 && x > 0 && y <= matrix.length && x <= matrix[0].length) {
                    String c1 = map[y][x].substring(0,cl);
                    String c2 = map[y][x].substring(cl,2*cl);
                    String c3 = map[y][x].substring(2*cl);
                    if (matrix[y-1][x-1] > 1) {
                        c3 = c2.equals(YELLOW_B) && c3.equals("  ") ? String.format("%1$2d", matrix[y-1][x-1]) : c3;
                    } else if(matrix[y-1][x-1] == 1) {
                        c3 = c1 + c2 + STONE;
                    }
                    System.out.print(c1 + c2 + c3);
                }
                else
                    System.out.print(map[y][x]);
            }
            System.out.println(RESET);
        }
        System.out.println(RESET);
    }

    public class Cord{
        private int y, x;

        public Cord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object other) {
            return other != null && other instanceof Cord &&
                this.y == ((Cord)other).y && this.x == ((Cord)other).x;
            
        }

        @Override
        public int hashCode() {
            return this.y * 1000 + this.x;
        }
    }
}
    


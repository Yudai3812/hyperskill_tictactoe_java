package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] arrays = new String[3][3];
        
        //initial condition
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
        	System.out.print("| ");
        	for (int j = 0; j < 3; j++) {
        		arrays[i][j] = " ";
        		System.out.print(arrays[i][j] + " ");		
        	}
        	System.out.println("|");
        }
        System.out.println("---------");
        
        
        // roop
        Scanner scanner2 = new Scanner(System.in);
        int n1, n2, n3, n4;
        int counter = 0;
        String judge = null;
        loop : while (true) {
            n1 = scanner2.nextInt();
            n2 = scanner2.nextInt();
            try {
                if (n1 < 1 || n1 > 3 || n2 < 1 || n2 > 3) {
                	System.out.println("Coordinates should be from 1 to 3!");
                	continue;
                } else if (arrays[n1 - 1][n2 - 1].equals("X") || arrays[n1 - 1][n2 - 1].equals("O")) {
                	System.out.println("This cell is occupied! Choose another one!");
                	continue;
                } else {
                	if (counter % 2 == 0) {
                		arrays[n1 - 1][n2 - 1] = "X";
                	} else {
                		arrays[n1 - 1][n2 - 1] = "O";
                	}
                	counter++;
                	
                }
                
                // output of x
                System.out.println("---------");
                for (int i = 0; i < 3; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < 3; j++) {
                    	if (arrays[i][j].equals("_")) {
                    		System.out.print("  ");
                    	} else {
                    		System.out.print(arrays[i][j] + " ");
                    	}
                    	
                    }
                    System.out.println("|");
                }
                System.out.println("---------");
                
             // judgement of finish
                for (int i = 0; i < 3; i++) {
                	if (arrays[i][0].equals(arrays[i][1]) && arrays[i][1].equals(arrays[i][2]) && arrays[i][2].equals("X")
                			|| arrays[0][i].equals(arrays[1][i]) && arrays[1][i].equals(arrays[2][i]) && arrays[2][i].equals("X")
                			|| arrays[0][0].equals(arrays[1][1]) && arrays[1][1].equals(arrays[2][2]) && arrays[2][2].equals("X")
                			|| arrays[0][2].equals(arrays[1][1]) && arrays[1][1].equals(arrays[2][0]) && arrays[2][0].equals("X")) {
                		judge = "X wins";
                		System.out.println(judge);
                		break loop;
                	}
                	if (arrays[i][0].equals(arrays[i][1]) && arrays[i][1].equals(arrays[i][2]) && arrays[i][2].equals("O")
                			|| arrays[0][i].equals(arrays[1][i]) && arrays[1][i].equals(arrays[2][i]) && arrays[2][i].equals("O")
                			|| arrays[0][0].equals(arrays[1][1]) && arrays[1][1].equals(arrays[2][2]) && arrays[2][2].equals("O")
                			|| arrays[0][2].equals(arrays[1][1]) && arrays[1][1].equals(arrays[2][0]) && arrays[2][0].equals("O")) {
                		judge = "O wins";
                		System.out.println(judge);
                		break loop;
                	}
                }
                
                
                if (!Arrays.asList(arrays[0]).contains(" ") && !Arrays.asList(arrays[1]).contains(" ") && !Arrays.asList(arrays[2]).contains(" ") 
                		&& judge != "X wins" && judge != "O wins") {
                   	judge = "Draw";
                   	System.out.println(judge);
                   	break loop;
                }	
                
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            
          }
    }
}
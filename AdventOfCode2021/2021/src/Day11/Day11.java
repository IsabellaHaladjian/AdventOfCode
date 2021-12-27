/*
FIXME: AGHHHHHHHHHHHHHHHHHHH I CAN'T MAKE IT WORK
*/

package Day11;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {

    private static ArrayList<String> lines = new ArrayList<String>();
    private static Integer[][] grid = new Integer[10][10];
    private static int flashCount = 0;

    public static void challenge1() {

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day11/Day11ExInput.txt");
            Scanner reader = new Scanner(input);
    
            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
    
            reader.close();
    
        } catch (FileNotFoundException e) {
    
            System.out.println("File not found");
            e.printStackTrace();
    
        }

        for(int i = 0; i < 10; i++) {
            String[] digitsString = lines.get(i).split("|");
            for(int a = 0; a < 10; a++) {
                grid[i][a] = Integer.parseInt(digitsString[a]);
            }
        }

        int steps = 1;

        while(steps <= 100) {

            boolean[][] hasFlashed = new boolean[10][10];
    
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int energy = grid[i][j];
                if(energy >= 9 && !hasFlashed[i][j]) {
                    //flash(i, j, hasFlashed);
                    hasFlashed[i][j] = true;
                }
                grid[i][j]++;
            }
        }

            steps++;

        }

    }

/*    public static void flash(int i, int j, boolean[][] hasFlashed) {
        if(!hasFlashed[i][j]) {
            grid[i][j] = 0;
            grid[i-1][j]++;
            grid[i+1][j]++;
            grid[i][j+1]++;
            grid[i][j-1]++;
            grid[i-1][j-1]++;
            grid[i+1][j+1]++;
            grid[i-1][j+1]++;
            grid[i+1][j-1]++;
            if(grid[i-1][j] >= 9) {
                flash(i-1, j);
            }
            if(grid[i+1][j] >= 9) {
                flash(i+1, j);
            }
            if(grid[i][j+1]++ >= 9) {
                flash(i, j+1);
            }
            if(grid[i][j-1] >= 9) {
                flash(i, j-1);
            }
            if(grid[i-1][j-1] >= 9) {
                flash(i-1, j-1);
            }
            if(grid[i+1][j+1] >= 9) {
                flash(i+1, j+1);
            }
            if(grid[i-1][j+1] >= 9) {
                flash(i-1, j+1);
            }
            if(grid[i+1][j-1] >= 9) {
                flash(i+1, j-1);
            }

            flashCount++;
        }
        

    } */

    public static void main(String[] args) {
        challenge1();
    }

}

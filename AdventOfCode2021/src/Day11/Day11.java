package Day11;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11 {

    private static ArrayList<String> lines = new ArrayList<String>();
    private static Integer[][] grid = new Integer[10][10];

    public static void challenge1() {

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day11ExInput.txt");
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
    
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    int energy = grid[i][j];
                }
            }

            steps++;

        }

    }

    public static void main(String[] args) {
        challenge1();
    }

}

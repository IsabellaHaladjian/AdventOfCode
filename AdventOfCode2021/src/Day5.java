import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {

    public static void challenge1() {

        ArrayList<String> lines = new ArrayList<String>();

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day5Input.txt");
            Scanner reader = new Scanner(input);

            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
 
            reader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

        Integer[][] grid = new Integer[999][999];
        for(int a = 0; a < 999; a++) {
            for(int b = 0; b < 999; b++) {
                grid[a][b] = 0;
            }
        }

        for(int i = 0; i < lines.size(); i++) {
            String entireLine = lines.get(i);
            String[] coordinates = entireLine.split(" -> ");
            String[] coordinate1 = coordinates[0].split(",");
            String[] coordinate2 = coordinates[1].split(",");
            int x1 = Integer.valueOf(coordinate1[0]);
            int y1 = Integer.valueOf(coordinate1[1]);
            int x2 = Integer.valueOf(coordinate2[0]);
            int y2 = Integer.valueOf(coordinate2[1]);
            ArrayList<Integer> trueYValues = new ArrayList<Integer>();
            ArrayList<Integer> trueXValues = new ArrayList<Integer>();
            if(x1 == x2 || y1 == y2){   
            for(int z = 0; z < 999; z++) {
                //add to true x values
                if(x1 > x2) {
                    if(z <= x1 && z >= x2) {
                        trueXValues.add(z);
                    }
                } else if(x2 > x1) {
                    if(z >= x1 && z <= x2) {
                        trueXValues.add(z);
                    }
                } else if(x2 == x1) {
                    if(x1 == z) {
                        trueXValues.add(z);
                    }
                } 
                //add to true y values
                if(y1 > y2) {
                    if(z <= y1 && z >= y2) {
                        trueYValues.add(z);
                    }
                } else if(y2 > y1) {
                    if(z >= y1 && z <= y2) {
                        trueYValues.add(z);
                    }
                } else if(y2 == y1) {
                    if(y1 == z) {
                        trueYValues.add(z);
                    }
                }
            }

            if(trueXValues.size() == 1) {
                for(int r = 0; r < trueYValues.size(); r++) {
                    grid[trueXValues.get(0)][trueYValues.get(r)]++;
                }
            } else if(trueYValues.size() == 1) {
                for(int g = 0; g < trueXValues.size(); g++) {
                    grid[trueYValues.get(0)][trueXValues.get(g)]++;
                }
            }

        }}

        int counter = 0;
        for(int x = 0; x < 999; x++) {
            for(int y = 0; y < 999; y++) {
                if(grid[x][y] > 1) {
                    counter++;
                }
            }
        } 

        System.out.println(counter);

    }

    public static void main(String[] args) {

        challenge1();

    }


}

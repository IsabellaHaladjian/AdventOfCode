package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    private static ArrayList<String> readings;
    private static String [][] forest;

    public static void setup() {

        try{

            File numbers = new File("/Users/isabellahaladjian/Desktop/Coding/AdventOfCode-2021/AdventOfCode/2020/src/Day3/Day3Input.txt");
            Scanner input = new Scanner(numbers);
            readings = new ArrayList<String>();
            while(input.hasNextLine()) {
                readings.add(input.nextLine());
            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

        forest = new String[readings.size() * 7][(readings.size())];

        for(int i = 0; i < readings.size(); i++) {

            String[] line = readings.get(i).split("|");

            for(int j = 0; j < (readings.size() * 7); j++) {

                int corrected = j % line.length;

                forest[j][i] = line[corrected];

            }

        }

        System.out.println(forest[0][0]);

    }

    public static int challenge1() {

        int treeCounter = 0;
        int lineCounter = 0;
        int x = 0;
        int y = 0;

        while(lineCounter < 323) {

            if(forest[x][y].equals("#")) {
                treeCounter++;
            }

            x += 3;
            y += 1;

            lineCounter++;

        }

        return treeCounter;

    }

    public static int challenge2pt1() {

        int treeCounter = 0;
        int lineCounter = 0;
        int x = 0;
        int y = 0;

        while(lineCounter < 323) {

            if(forest[x][y].equals("#")) {
                treeCounter++;
            }

            x += 1;
            y += 1;

            lineCounter++;

        }

        return treeCounter;

    }

    public static int challenge2pt2() {

        int treeCounter = 0;
        int lineCounter = 0;
        int x = 0;
        int y = 0;

        while(lineCounter < 323) {

            if(forest[x][y].equals("#")) {
                treeCounter++;
            }

            x += 3;
            y += 1;

            lineCounter++;

        }

        return treeCounter;

    }

    public static int challenge2pt3() {

        int treeCounter = 0;
        int lineCounter = 0;
        int x = 0;
        int y = 0;

        while(lineCounter < 323) {

            if(forest[x][y].equals("#")) {
                treeCounter++;
            }

            x += 5;
            y += 1;

            lineCounter++;

        }

        return treeCounter;

    }

    public static int challenge2pt4() {

        int treeCounter = 0;
        int lineCounter = 0;
        int x = 0;
        int y = 0;

        while(lineCounter < 323) {

            if(forest[x][y].equals("#")) {
                treeCounter++;
            }

            x += 7;
            y += 1;

            lineCounter++;

        }

        return treeCounter;

    }

    public static int challenge2pt5() {

        int treeCounter = 0;
        int lineCounter = 0;
        int x = 0;
        int y = 0;

        while(lineCounter < 161) {

            if(forest[x][y].equals("#")) {
                treeCounter++;
            }

            x += 1;
            y += 2;

            lineCounter++;

        }

        return treeCounter;

    }

    public static void main(String[] args) {

        setup();
        System.out.println("Challenge 1: " + challenge1());
        long num = challenge2pt1() * challenge2pt2() * challenge2pt3() * challenge2pt4() * challenge2pt5();
        System.out.println("Challenge 2: " + num);

    }

}

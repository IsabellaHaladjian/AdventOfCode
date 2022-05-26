package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    
    static ArrayList<String> readings;

    public static void parseInput() {

        try{

            File numbers = new File("/Users/isabellahaladjian/Desktop/Coding/AdventOfCode-2021/AdventOfCode/2020/src/Day2/Day2Input.txt");
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

    }

    public static int challenge1() {

        int validPasswordCounter = 0;

        for(int i = 0; i < readings.size(); i++) {

            String line = readings.get(i); 

            String[] twoParts = line.split(":");
            String[] chars = twoParts[1].split("|");

            String[] minMax = twoParts[0].split("-");
            String[] maxChar = minMax[1].split(" ");

            int min = Integer.parseInt(minMax[0]);
            String max = maxChar[0];
            String letter = maxChar[1];

            int charCounter = 0;

            for(int k = 1; k < (chars.length); k++) {
                if(chars[k].equals(letter)) {
                    charCounter++;
                }
            }

            if(charCounter >= min && charCounter <= Integer.parseInt(max)) {
                validPasswordCounter++;
            }

        }

        return validPasswordCounter;

    }

    public static void main(String args[]) {

        parseInput();
        System.out.println(challenge1());

    }


}

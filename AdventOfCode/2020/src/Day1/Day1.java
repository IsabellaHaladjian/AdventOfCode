package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    static ArrayList<Integer> readings;

    public static void parseInput() {

        try{

            File numbers = new File("/Users/isabellahaladjian/Desktop/Coding/AdventOfCode-2021/AdventOfCode/2020/src/Day1/Day1Input.txt");
            Scanner input = new Scanner(numbers);
            readings = new ArrayList<Integer>();
            while(input.hasNextInt()) {
                readings.add(input.nextInt());
            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

    }

    public static int challenge1() {

        int value1;
        int value2;

        for(int i = 0; i < readings.size(); i++) {
            int corresponding = 2020 - (readings.get(i));
            if(readings.contains(corresponding)) {
                value1 = readings.get(i);
                value2 = corresponding;
                return value1 * value2;
            }
        }

        return 0;

    }

    public static int challenge2() {

        int value1;
        int value2;
        int value3;

        for(int i = 0; i < readings.size(); i++) {
            for(int j = 0; j < readings.size(); j++) {
                int corresponding = (2020 - (readings.get(i)) - (readings.get(j)));
                if(readings.contains(corresponding)) {
                    value1 = readings.get(i);
                    value2 = readings.get(j);
                    value3 = corresponding;
                    return value1 * value2 * value3;
                }
            }
        }

        return 0;

    }

    public static void main(String args[]) {

        parseInput();
        System.out.println(challenge1());
        System.out.println(challenge2());

    }


}

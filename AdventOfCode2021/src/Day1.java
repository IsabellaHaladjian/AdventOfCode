import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    public static void challenge1() {

        try{

            File numbers = new File("/Users/isabellahaladjian/Desktop/AdventOfCode2021/src/Day1Input.txt");
            Scanner input = new Scanner(numbers);
            ArrayList<Integer> readings = new ArrayList<Integer>();
            while(input.hasNextInt()) {
                readings.add(input.nextInt());
            }

            int counter = 0;

            for(int i = 1; i < readings.size(); i++) {
                if(readings.get(i-1) < readings.get(i)) {
                    counter++;
                } else {
                    //do nothing
                }
            }

            System.out.println("The total number of increases is: " + counter);
            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

    }

    public static void challenge2() {

        try{

            File numbers = new File("/Users/isabellahaladjian/Desktop/AdventOfCode2021/src/Day1Input.txt");
            Scanner input = new Scanner(numbers);
            ArrayList<Integer> readings = new ArrayList<Integer>();
            while(input.hasNextInt()) {
                readings.add(input.nextInt());
            }

            int counter = 0;

            for(int i = 1; i < readings.size(); i++) {

                if(i < (readings.size() - 2)) {

                    int value1 = readings.get(i);
                    int value2 = readings.get(i+1);
                    int value3 = readings.get(i+2);
                    int total = value1 + value2 + value3;

                    int prev1 = readings.get(i-1);
                    int prev2 = readings.get(i);
                    int prev3 = readings.get(i+1);
                    int prevTotal = prev1 + prev2 + prev3;

                    if(total > prevTotal) {
                        counter++;
                    }

                }

            }

            System.out.println("The total number of windows that increase is: " + counter);
            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

    }

    public static void main(String args[]) {

        challenge1();
        challenge2();


    }

}

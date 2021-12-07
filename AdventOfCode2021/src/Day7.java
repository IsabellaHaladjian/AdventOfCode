import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day7 {

    private static String[] positions;
   
    public static double getAverage() {

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day7ExInput.txt");
            Scanner reader = new Scanner(input);

            positions = reader.next().split(",");
 
            reader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

            positions = null;

        }

        double total = 0;
        double avg = 0;

        for(int i = 0; i < positions.length; i++) {
            double position = Integer.valueOf(positions[i]);
            total = position + total;
        }

        avg = total / positions.length;
        return avg;

    }

    public static void challenge1(int intAvg) {

        int fuelSpent = 0;

        for(int p = 0; p < positions.length; p++) {
            int position = Integer.valueOf(positions[p]);
            fuelSpent = fuelSpent + Math.abs(position - intAvg); 
        }

        System.out.println(fuelSpent);

    }

    public static void main(String[] args) {
        System.out.println(getAverage());
        challenge1(5);
    }

}

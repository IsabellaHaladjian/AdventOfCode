import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day7 {

    private static String[] positions;
   
    public static int getMedian() {

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

        Arrays.sort(positions);
        int length = positions.length;
        int medianIndex = 0;
        if(length % 2 == 0) {
            medianIndex = (length / 2);
        } else {
            medianIndex = (length + 1) / 2;
        }
        int median = Integer.valueOf(positions[medianIndex]);

        return median;

    }

    public static void challenge1(int median) {

        int fuelSpent = 0;

        for(int p = 0; p < positions.length; p++) {
            int position = Integer.valueOf(positions[p]);
            fuelSpent = fuelSpent + Math.abs(position - median); 
        }

        System.out.println(fuelSpent);

    }

    public static void main(String[] args) {
        System.out.println(getMedian());
        challenge1(getMedian());
    }

}

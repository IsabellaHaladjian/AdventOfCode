import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Day3 {
    
    public static void challenge1() {

        try{

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day3Input.txt");
            Scanner reader = new Scanner(input);

            ArrayList<String> lines = new ArrayList<String>();

            int[] zeroes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] ones = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            while(reader.hasNext()) {
                lines.add(reader.next());
            }

            for(int i = 0; i < lines.size(); i++) {
                for(int b = 0; b < 12; b++) {
                    if(lines.get(i).indexOf("0", b) == b) {
                        int counter = zeroes[b];
                        counter++;
                        zeroes[b] = counter;
                    } else if(lines.get(i).indexOf("1", b) == b) {
                        int counter = ones[b];
                        counter++;
                        ones[b] = counter;
                    }
                }
            }

            int[] gamma = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //more common
            int[] epsilon = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //less common

            for(int i = 0; i < 12; i++) {
                int numZeroes = zeroes[i];
                int numOnes = ones[i];
                if(numZeroes > numOnes) {
                    gamma[i] = 0;
                    epsilon[i] = 1;
                } else if(numOnes > numZeroes) {
                    gamma[i] = 1;
                    epsilon[i] = 0;
                }
                System.out.println("gamma: " + i + " " + gamma[i]);
                System.out.println("epsilon: " + i + " " + epsilon[i]);

            }

            /*double[] gammaDecimal = new double[12];
            double[] epsilonDecimal = new double[12];

            for(int i = 11; i >= 0; i--) {
                double binary = gamma[i];
                double otherBinary = epsilon[i];
                binary = binary * Math.pow(2, (12-i));
                otherBinary = otherBinary * Math.pow(2, (12-i));
                gammaDecimal[i] = binary;
                epsilonDecimal[i] = otherBinary;
            }

            double gammaTotal = gammaDecimal[0] + gammaDecimal[1] + gammaDecimal[2] + gammaDecimal[3] + gammaDecimal[4] + gammaDecimal[5] + gammaDecimal[6] + gammaDecimal[7] + gammaDecimal[8] + gammaDecimal[9] + gammaDecimal[10] + gammaDecimal[11];
            double epsilonTotal = epsilonDecimal[0] + epsilonDecimal[1] + epsilonDecimal[2] + epsilonDecimal[3] + epsilonDecimal[4] + epsilonDecimal[5] + epsilonDecimal[6] + epsilonDecimal[7] + epsilonDecimal[8] + epsilonDecimal[9] + epsilonDecimal[10] + epsilonDecimal[11];

            System.out.println("gamma: " + gammaTotal);
            System.out.println("epsilon: " + epsilonTotal);
            System.out.println("power consumption: " + (gammaTotal * epsilonTotal)); */

            reader.close(); 

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
 
    }

    public static void main(String[] args) {

        challenge1();

    }

}

//TODO: come back and fix day 3

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//import java.lang.Math;

public class Day3 {

    public static void challenge1() {

        ArrayList<String> lines = new ArrayList<String>();

        try{
            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day3Input.txt");
            Scanner reader = new Scanner(input);
            while(reader.hasNext()) {
                lines.add(reader.next());
            }
            reader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        int[] zeroes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] ones = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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
            System.out.println("gamma: " + i + " " + gamma[i]); //gamma: 111011100000 = 32, 64, 128, 512, 1024, 2048 = 3808
            System.out.println("epsilon: " + i + " " + epsilon[i]); //epsilon: 000100011111 = 1, 2, 4, 8, 16, 256 = 287 
        }

            //TODO: binary to decimal convertor doesn't work, fix this

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

            double gammaTotal = 0;
            double epsilonTotal = 0;

            for(int i = 0; i < 12; i++) {
                gammaTotal = gammaTotal + gammaDecimal[i];
                epsilonTotal = epsilonTotal + epsilonDecimal[i];
            }

            System.out.println("gamma: " + gammaTotal);
            System.out.println("epsilon: " + epsilonTotal);
            System.out.println("power consumption: " + (gammaTotal * epsilonTotal)); */

    }

    public static void challenge2generator() {

        ArrayList<String> lines = new ArrayList<String>();

        try{
            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day3ExInput.txt");
            Scanner reader = new Scanner(input);
            while(reader.hasNext()) {
                lines.add(reader.next());
            }
            reader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        int times = 0;

        while(lines.size() > 1) {

        int zeroesCounter = 0;
        int onesCounter = 0;
        
            /*for(int i = 0; i < lines.size(); i++) {
                if(lines.get(i).indexOf("0", times) == 0) {
                    zeroesCounter++;
                } else if(lines.get(i).indexOf("1", times) == 0) {
                    onesCounter++;
                }
            } */

            if(zeroesCounter > onesCounter) {
                for(int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).indexOf("1", times) == 0) {
                        lines.remove(lines.get(i));
                    }
                }
                System.out.println("zeroes");
            } else if(onesCounter > zeroesCounter) {
                for(int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).indexOf("0", times) == 0) {
                        lines.remove(lines.get(i));
                    }
                }
                System.out.println("ones");
            } else if(onesCounter == zeroesCounter) {
                for(int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).indexOf("0", times) == 0) {
                        lines.remove(lines.get(i));
                    }
                }
            }

            times++;
        }

        System.out.println("02 Generator Rating: " + lines);
    }

    public static void challenge2scrubber() {

        ArrayList<String> lines = new ArrayList<String>();

        try{
            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day3ExInput.txt");
            Scanner reader = new Scanner(input);
            while(reader.hasNext()) {
                lines.add(reader.next());
            }
            reader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        int zeroesCounter = 0;
        int onesCounter = 0;

        int times = 0;

        while(lines.size() > 1) {

            for(int i = 0; i < lines.size(); i++) {
                if(lines.get(i).indexOf("0", times) == 0) {
                    zeroesCounter++;
                } else if(lines.get(i).indexOf("1", times) == 0) {
                    onesCounter++;
                }
            }
    
            if(zeroesCounter < onesCounter) {
                for(int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).indexOf("1", times) == 0) {
                        lines.remove(lines.get(i));
                    }
                }
            } else if(onesCounter < zeroesCounter) {
                for(int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).indexOf("0", times) == 0) {
                        lines.remove(lines.get(i));
                    }
                }
            } else if(onesCounter == zeroesCounter) {
                for(int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).indexOf("0", times) == 0) {
                        lines.remove(lines.get(i));
                    }
                }
            }

            times++;
        }
        System.out.println("C02 Scrubber rating: " + lines);
    }

    public static void main(String[] args) {

        //challenge1();
        challenge2generator(); //02 Generator Rating: [111011000101] = 1,0,4,64,128,512,1024,2048 = 3781
        //challenge2scrubber(); //C02 Scrubber rating: [011111001001] = 1993

    }

}

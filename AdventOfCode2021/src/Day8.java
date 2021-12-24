//Doesn't work for part 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

    public static ArrayList<String> outputs = new ArrayList<String>();
    public static ArrayList<String> inputs = new ArrayList<String>();

    public static void challenge1() {

        ArrayList<String> lines = new ArrayList<String>();

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day8ExInput.txt");
            Scanner reader = new Scanner(input);

            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
    
            reader.close();
    
        } catch (FileNotFoundException e) {
    
            System.out.println("File not found");
            e.printStackTrace();
    
        }

        for(int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split(" | ");
            String concatedInputs = split[0].concat(" " + split[1]).concat(" " + split[2]).concat(" " + split[3]).concat(" " + split[4]).concat(" " + split[6]).concat(" " + split[7]).concat(" " + split[8]).concat(" " + split[9]);
            String concatedOutputs = split[11].concat(" " + split[12]).concat(" " + split[13]).concat(" " + split[14]);
            outputs.add(concatedOutputs);
            inputs.add(concatedInputs);
        }

        int counter = 0;

        for(int i = 0; i < outputs.size(); i++) {
            String[] indiv = outputs.get(i).split(" ");
            for(int j = 0; j < 4; j++) {
                switch(indiv[j].length()) {
                    case 2: counter++;
                        break;
                    case 4: counter++; 
                        break;  
                    case 3: counter++;
                        break;
                    case 7: counter++;
                        break;
                    default: counter = counter + 0;
                        break;             
                }
            }
        }

        System.out.println(counter);

    }

    public static void challenge2() {

        ArrayList<Integer> concatedValues = new ArrayList<Integer>();

        for(int i = 0; i < outputs.size(); i++) {
            String[] indivOutputs = outputs.get(i).split(" ");
            String[] indivInputs = inputs.get(i).split(" ");
            Integer[] inputNumbers = new Integer[10];
            for(int j = 0; j < 10; j++) {
                inputNumbers[j] = deduceNumbers(indivInputs[j]);
            }
            String firstValue = inputNumbers[0].toString();
            String secondValue = inputNumbers[1].toString();
            String thirdValue = inputNumbers[2].toString();
            String fourthValue = inputNumbers[3].toString();
            String concated = firstValue.concat(secondValue).concat(thirdValue).concat(fourthValue);
            concatedValues.add(Integer.parseInt(concated));
        }

        System.out.println(concatedValues.size());
        System.out.println(concatedValues);

        //AGH NO I JUST REALIZED I HAVE TO WRITE A PROGRAM TO DO WHAT I MANUALLY DID LAST NIGHT AGHHHHHH
        //my christmas gift to myself is doing this later so see ya terrible code

    }

    public static int deduceNumbers(String output) {

        int length = output.length();

        int returnable = 10;



        return returnable;

    }

    public static void main(String[] args) {
        challenge1();
        challenge2();
    }

}

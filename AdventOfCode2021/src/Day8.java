import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

    public static ArrayList<String> outputs = new ArrayList<String>();

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
            String concated = split[11].concat(" " + split[12]).concat(" " + split[13]).concat(" " + split[14]);
            outputs.add(concated);
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
                    default: counter = counter;
                        break;             
                }
            }
        }

        System.out.println(counter);

    }

    public static void challenge2() {

        ArrayList<Integer> concatedValues = new ArrayList<Integer>();

        for(int i = 0; i < outputs.size(); i++) {
            String[] indiv = outputs.get(i).split(" ");
            Integer[] values = new Integer[4];
            for(int j = 0; j < 4; j++) {
                values[j] = deduceValues(indiv[j]);
            }
            String firstValue = values[0].toString();
            String secondValue = values[1].toString();
            String thirdValue = values[2].toString();
            String fourthValue = values[3].toString();
            String concated = firstValue.concat(secondValue).concat(thirdValue).concat(fourthValue);
            concatedValues.add(Integer.parseInt(concated));
        }

        System.out.println(concatedValues.size());
        System.out.println(concatedValues);

        //AGH NO I JUST REALIZED I HAVE TO WRITE A PROGRAM TO DO WHAT I MANUALLY DID LAST NIGHT AGHHHHHH
        //my christmas gift to myself is doing this later so see ya terrible code

    }

    public static int deduceValues(String output) {

        int length = output.length();

        int returnable = 10;

        switch(length) {
            case 2: returnable = 1;
                break;
            case 3: returnable = 7;
                break;
            case 4: returnable = 4;
                break;
            case 7: returnable = 8;
                break;
            case 5:
                if(output.contains("e")) {
                    returnable = 5;
                } else if(output.contains("g")) {
                    returnable = 2;
                } else {
                    returnable = 3;
                }
                break;
            case 6: 
                if(output.contains("a") && output.contains("f")) {
                    returnable = 9;
                } else if(output.contains("a")) {
                    returnable = 0;
                } else {
                    returnable = 6;
                }
                break;
            default: returnable = 10;
                break;
        }

        return returnable;

    }

    public static void main(String[] args) {
        challenge1();
        challenge2();
    }

}

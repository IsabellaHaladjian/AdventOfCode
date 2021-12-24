import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

    public static ArrayList<String> outputs = new ArrayList<String>();

    public static void challenge1() {

        ArrayList<String> lines = new ArrayList<String>();

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day8Input.txt");
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

        for(int i = 0; i < outputs.size(); i++) {
            String[] indiv = outputs.get(i).split(" ");
            for(int j = 0; j < 4; j++) {
                int length = indiv[i].length();
                //TODO: AGHHHHH SO CLOSE BUT ITS LIKE 1 AM AND I SHOULD PROLLY SLEEP CAUSE TOMORROW IS XMAS
            }
        }

    }

    public static void main(String[] args) {
        //challenge1();
        challenge2();
    }

}

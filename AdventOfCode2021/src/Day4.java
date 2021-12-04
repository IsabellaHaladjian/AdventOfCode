import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    public static final ArrayList<String> allBoards = new ArrayList<String>();
   
    public static void challenge1() {

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day4Input.txt");
            Scanner reader = new Scanner(input);

            while(reader.hasNextLine()) {
                allBoards.add(reader.nextLine());
            }
 
            reader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

        List<String> separatedLines = new ArrayList<String>();
            String space = " ";
            String[] line = allBoards.get(2).split(space);
            separatedLines = Arrays.asList(line);
            for(int i = 0; i < line.length; i++) {
                if(separatedLines.get(i).equals(" ")) {
                    separatedLines.remove(separatedLines.get(i));
                }
                System.out.println(separatedLines.get(i));
            }

    }

    public static void main(String[] args) {

        challenge1();

    }


}

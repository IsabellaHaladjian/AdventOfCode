import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {

    public static void challenge1() {

        ArrayList<String> lines = new ArrayList<String>();

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day6ExInput.txt");
            Scanner reader = new Scanner(input);

            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
 
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

package Day6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {

    public static void challenge1() {

        ArrayList<String> line = new ArrayList<String>();

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day6Input.txt");
            Scanner reader = new Scanner(input);

            line.add(reader.nextLine());
 
            reader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

        String[] fishArray;
        fishArray = line.get(0).split(",");
        ArrayList<String> fish = new ArrayList<String>();
        for(int g = 0; g < fishArray.length; g++) {
            fish.add(fishArray[g]);
        }

        for(int d = 0; d < 256; d++) {

            for(int a = 0; a < fish.size(); a++) {
                if(fish.get(a).equals("0")) {
                    fish.set(a, "6");
                    fish.add("9");
                } else {
                    int value = Integer.valueOf(fish.get(a));
                    value --;
                    String toS = Integer.toString(value);
                    fish.set(a, toS);
                }
            }

        }

        System.out.println(fish.size());

    }

    public static void main(String[] args) {
        challenge1();
    }


}

package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

    public static void challenge1() {

        try{

            ArrayList<String> lines = new ArrayList<String>();
            ArrayList<String> directions = new ArrayList<String>();
            ArrayList<Integer> distances = new ArrayList<Integer>();

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day2Input.txt");

            Scanner reader = new Scanner(input);

            while(reader.hasNext()) {
                lines.add(reader.next());
                distances.add(reader.nextInt());
            }

            for(int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] split = line.split(" ");
                directions.add(split[0]);
            }

            int horizontalX = 0;
            int depthY = 0;

            for(int i = 0; i < lines.size(); i++) {
                int distance = distances.get(i);
                if(directions.get(i).equals("down")) {
                    depthY = depthY + distance;
                } else if(directions.get(i).equals("up")) {
                    depthY = depthY - distance;
                } else if(directions.get(i).equals("forward")) {
                    horizontalX = horizontalX + distance;
                }
            } 

            System.out.println("Horizontal coordinate for part 1 is: " + horizontalX);
            System.out.println("Depth coordinate for part 1 is: " + depthY);
            System.out.println("Solution for part 1 is: " + (depthY * horizontalX));

            reader.close(); 

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
 
    }

    public static void challenge2() {

        try{

            ArrayList<String> lines = new ArrayList<String>();
            ArrayList<String> directions = new ArrayList<String>();
            ArrayList<Integer> distances = new ArrayList<Integer>();

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day2Input.txt");

            Scanner reader = new Scanner(input);

            while(reader.hasNext()) {
                lines.add(reader.next());
                distances.add(reader.nextInt());
            }

            for(int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] split = line.split(" ");
                directions.add(split[0]);
            }

            int horizontalX = 0;
            int depthY = 0;
            int aimZ = 0;

            for(int i = 0; i < lines.size(); i++) {
                int distance = distances.get(i);
                if(directions.get(i).equals("down")) {
                    aimZ = aimZ + distance;
                } else if(directions.get(i).equals("up")) {
                    aimZ = aimZ - distance;
                } else if(directions.get(i).equals("forward")) {
                    horizontalX = horizontalX + distance;
                    depthY = depthY + (aimZ * distance);
                }
            } 

            System.out.println("Horizontal coordinate for part 2 is: " + horizontalX);
            System.out.println("Depth coordinate for part 2 is: " + depthY);
            System.out.println("Aim for part 2 is: " + aimZ);
            System.out.println("Solution for part 2 is: " + (depthY * horizontalX));

            reader.close(); 

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
 
    }
   
    public static void main(String[] args) {

        challenge1();
        challenge2();

    }

}

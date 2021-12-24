import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {

    private static ArrayList<String> entireInput = new ArrayList<String>();
   
    public static void challenge1() {

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day4ExInput.txt");
            Scanner reader = new Scanner(input);

            while(reader.hasNext()) {
                entireInput.add(reader.next());
            }

            System.out.println(entireInput.size());

            reader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            e.printStackTrace();

        }

        int numBoards = ((entireInput.size() - 1)/25);

        int[][] boards;
        boards = new int[entireInput.size() - 1][5];

        for(int i = 1; i < entireInput.size(); i++) {
            int horizontalPosition;
            switch(i) {
                case 1: horizontalPosition = 0;
                    break;
                case 2: horizontalPosition = 1;
                    break;
                case 3: horizontalPosition = 2;
                    break;
                case 4: horizontalPosition = 3;
                    break;
                case 5: horizontalPosition = 4;
                    break;
                default: horizontalPosition = ((i%5) - 1);
                    break;
            }
            if(horizontalPosition < 0) {
                horizontalPosition = 0;
            }
            boards[i-1][horizontalPosition] = Integer.parseInt(entireInput.get(i));
        }

        

        for(int i = 0; i < numBoards; i++) {
            for(int j = 0; j < 25; j++) {
                
            }
        }

    



    }

    public static void main(String[] args) {

        challenge1();

    }


}

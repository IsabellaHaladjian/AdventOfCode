package Day10;
/*
FIXME: doesn't work
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10 {

    public static void challenge1() {

        ArrayList<String> lines = new ArrayList<String>();

        try {

            File input = new File("/Users/isabellahaladjian/Desktop/AdventOfCode-2021/AdventOfCode2021/src/Day9Input.txt");
            Scanner reader = new Scanner(input);
    
            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
    
            reader.close();
    
        } catch (FileNotFoundException e) {
    
            System.out.println("File not found");
            e.printStackTrace();
    
        }

        int totalScore = 0;

        for(int l = 0; l < lines.size(); l++) {
            String line = lines.get(l);
            ArrayList<Character> chars = new ArrayList<Character>();
            for(int x = 0; x < line.length(); x++) {
                chars.add(line.charAt(x));
            }
            for(int i = 0; i < line.length(); i++) {
                char opener = chars.get(i);
                String matchingCloser = Character.toString(getMatchingCloser(opener));
                if(line.contains(matchingCloser)) {
                    int ind = line.indexOf(matchingCloser);
                    chars.remove(i);
                    chars.remove(ind);
                } else {
                    int score = getScore(opener);
                    totalScore = totalScore + score;
                }
            }
        }

        System.out.println(totalScore);

    }

    public static char getMatchingCloser(char opener) {
        if(opener == '{') {
            return '}';
        } else if(opener == '[') {
            return '[';
        } else if(opener == '<') {
            return '>';
        } else if(opener == '(') {
            return ')';
        } else {
            return '?';
        }
    }

    public static int getScore(char opener) {
        if(opener == '{') {
            return 1197;
        } else if(opener == '[') {
            return 57;
        } else if(opener == '<') {
            return 25137;
        } else if(opener == '(') {
            return 3;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        challenge1();
    }

}

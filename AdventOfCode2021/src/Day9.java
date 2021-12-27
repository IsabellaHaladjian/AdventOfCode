import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {

    public static ArrayList<String> lines = new ArrayList<String>();
    public static Integer[][] grid;

    public static void challenge1() {

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

        grid = new Integer[lines.size()][lines.get(0).length()];

        for(int i = 0; i < lines.size(); i++) {
            String[] digits = lines.get(i).split("|");
            for(int a = 0; a < digits.length; a ++) {
                grid[i][a] = Integer.parseInt(digits[a]);             
            }
        }

        int totalRisk = 0;

        for(int i = 0; i < lines.size(); i++) {
            for(int j = 0; j < lines.get(0).length(); j++) {
                int height = grid[i][j];
                boolean leftBound = false;
                boolean rightBound = false;
                boolean topBound = false;
                boolean bottomBound = false;
                if(j == 0) {
                    leftBound = true;
                }
                if(j == (lines.get(0).length() - 1)) {
                    rightBound = true;
                }
                if(i == 0) {
                    topBound = true;
                }
                if(i == (lines.size() - 1)) {
                    bottomBound = true;
                }
                int risk = getRisk(leftBound, rightBound, topBound, bottomBound, i, j, height);
                totalRisk = totalRisk + risk;
            }
        }

        System.out.println(totalRisk);

    }

    public static int getRisk(boolean isLeftBound, boolean isRightBound, boolean isTopRow, boolean isBottomRow, int i, int j, int height) {
        if(isRightBound && isTopRow) {
            int left = grid[i][j-1];
            int down = grid[i+1][j];
            if(height < down) {
                if(height < left) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isLeftBound && isTopRow) {
            int right = grid[i][j+1];
            int down = grid[i+1][j];
            if(height < down) {
                if(height < right) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isRightBound && isBottomRow) {
            int left = grid[i][j-1];
            int up = grid[i-1][j];
            if(height < up) {
                if(height < left) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isLeftBound && isBottomRow) {
            int right = grid[i][j+1];
            int up = grid[i-1][j];
            if(height < up) {
                if(height < right) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isLeftBound) {
            int up = grid[i-1][j];
            int right = grid[i][j+1];
            int down = grid[i+1][j];
            if(height < up && height < down) {
                if(height < right) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isRightBound) {
            int up = grid[i-1][j];
            int left = grid[i][j-1];
            int down = grid[i+1][j];
            if(height < up && height < down) {
                if(height < left) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isTopRow) {
            int right = grid[i][j+1];
            int left = grid[i][j-1];
            int down = grid[i+1][j];
            if(height < down) {
                if(height < left && height < right) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else if(isBottomRow) {
            int up = grid[i-1][j];
            int right = grid[i][j+1];
            int left = grid[i][j-1];
            if(height < up) {
                if(height < left && height < right) {
                    int risk = height + 1;
                    return risk;
                }
            }
        } else {
            int up = grid[i-1][j];
            int right = grid[i][j+1];
            int left = grid[i][j-1];
            int down = grid[i+1][j];
            if(height < up && height < down) {
                if(height < left && height < right) {
                    int risk = height + 1;
                    return risk;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        challenge1();
    }

}

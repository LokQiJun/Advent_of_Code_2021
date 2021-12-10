/* Practice java codingss */
// shift + alt + f for auto indent
import java.util.*;
import java.io.*;

public class coding {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
        try {
            // Scanner scanner = new Scanner(System.in); // uncomment when submitting
            // scanner.useDelimiter("[,\\s+]");
            // * comment this whole section when submitting
            File in = new File("in.txt");
            Scanner scanner = new Scanner(in);
            PrintStream out = new PrintStream("out.txt");
            PrintStream err = new PrintStream("err.txt");
            System.setOut(out);
            System.setErr(err);
            // */
            String inputs;
            int[][] map = new int[1000][1000];
            int x1, x2, y1, y2, sx, sy;
            for (int[] row : map)
                Arrays.fill(row, 0); // set all to 0
            while (scanner.hasNext()) {
                inputs = scanner.next();
                String[] numbers = inputs.split(",");
                //System.out.println(numbers[0] + ' ' + numbers[1]);
                x1 = Integer.parseInt(numbers[0]);
                y1 = Integer.parseInt(numbers[1]);
                inputs = scanner.next();
                inputs = scanner.next();
                numbers = inputs.split(",");
                x2 = Integer.parseInt(numbers[0]);
                y2 = Integer.parseInt(numbers[1]);
                //System.out.println(numbers[0] + ' ' + numbers[1]);
                if(x1 == x2){ // vertical line
                    for(int i = Math.min(y1, y2); i <= Math.max(y1, y2); ++i){
                        map[x1][i] += 1;
                    }
                }
                else if(y1 == y2){ // horizontal line
                    for(int i = Math.min(x1, x2); i <= Math.max(x1, x2); ++i){
                        map[i][y1] += 1;
                    }
                }
                else if(Math.abs(x1 - x2) == Math.abs(y1 - y2)){ // diagonal line
                    if(x1 > x2) sx = -1;
                    else sx = 1;
                    if(y1 > y2) sy = -1;
                    else sy = 1;
                    for(int i = 0; i <= Math.abs(x1-x2); ++i){
                        map[x1 + (sx * i)][y1 + (sy * i)] += 1;
                    }
                }
            }
            System.out.println(counting(map));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    public static int counting(int[][] map) {
        int count = 0;
        for (int i = 0; i < 1000; ++i)
            for (int j = 0; j < 1000; ++j)
                if (map[i][j] >= 2)
                    ++count;
        return count;
    }
}

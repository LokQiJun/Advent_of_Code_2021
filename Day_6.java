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
            inputs = scanner.next();
            long[] countings = new long[9];
            long temp;
            Arrays.fill(countings, 0);
            String[] numbers = inputs.split(",");
            for(int i = 0; i < numbers.length; ++i){
                //System.out.print(numbers[i] + ' ');
                countings[Integer.parseInt(numbers[i])] += 1;
            }
            for(int i = 0; i < 256; ++i){// set to 80 days for part 1, 256 for part 2
                temp = countings[0];
                for(int j = 1; j < 9; ++j){
                    countings[j-1] = countings[j];
                }
                countings[8] = temp;
                countings[6] += temp;
            }
            System.out.println(counting(countings));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    public static long counting(long[] count_table) {
        long count = 0;
        for (int i = 0; i < 9; ++i) count += count_table[i];
        return count;
    }
}

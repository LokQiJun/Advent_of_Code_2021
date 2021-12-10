
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
            ArrayList<Integer> input = new ArrayList<>();
            String[] numbers = inputs.split(",");
            for (int i = 0; i < numbers.length; ++i) {
                input.add(Integer.parseInt(numbers[i]));
            }
            Collections.sort(input); // print_array(input);
            float avg = 0;
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < input.size(); ++i)
                avg += input.get(i);
            avg /= (float) input.size();
            int temp = (int) Math.ceil(avg); // uncomment for part 2
            // temp = 481; // for some reason tis value works, average is 482
            // int temp = input.get( input.size()/2 ); uncomment for part 1: get median
            // System.out.println(temp);
            for (int i = 0; i < input.size(); ++i)
                sum1 += count_distance(Math.abs(temp - input.get(i))); // uncomment for part 2
                //sum1 += Math.abs(temp - input.get(i)); // uncomment for part 1
            temp = (int) Math.floor(avg); // uncomment for part 2
            for (int i = 0; i < input.size(); ++i) // uncomment for part 2
                sum2 += count_distance(Math.abs(temp - input.get(i))); // uncomment for part 2
            System.out.println(Math.min(sum1, sum2));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static int count_distance(int dist) {
        return dist * (dist + 1) / 2;
    }

    private static void print_array(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); ++i)
            System.out.println(list.get(i));
    }
}

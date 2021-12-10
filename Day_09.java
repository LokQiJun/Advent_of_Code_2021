
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
            int counter = 0;
            ++counter; // comment for part 1
            String inputs = " ";
            String[] patterns = new String[100];
            ArrayList<Integer> low_points = new ArrayList<>();
            for (int i = 0; i < 100; ++i) {
                inputs = scanner.next();
                patterns[i] = inputs;
            }
            for (int i = 0; i < patterns.length; ++i) {
                for (int j = 0; j < patterns[i].length(); ++j) {
                    if (check_horizontal(patterns, i, j) && check_vertical(patterns, i, j))
                        low_points.add(get_basins_size(patterns, i, j));
                    //  counter += (Integer.parseInt(String.valueOf(patterns[i].charAt(j))) + 1);// uncomment for part 1
                }
            }
            Collections.sort(low_points, (a, b) -> b.compareTo(a));
            print_array(low_points);
            for (int i = 0; i < 3; ++i)
                counter *= low_points.get(i); // comment for part 1
            System.out.println(counter);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static Boolean check_horizontal(String[] inputs, int row, int col) {
        if (col - 1 < 0 || inputs[row].charAt(col) < inputs[row].charAt(col - 1))
            if (col + 1 >= inputs[row].length() || inputs[row].charAt(col) < inputs[row].charAt(col + 1))
                return true;
        return false;
    }

    private static Boolean check_vertical(String[] inputs, int row, int col) {
        if (row - 1 < 0 || inputs[row].charAt(col) < inputs[row - 1].charAt(col))
            if (row + 1 >= inputs.length || inputs[row].charAt(col) < inputs[row + 1].charAt(col))
                return true;
        return false;
    }

    private static int get_basins_size(String[] inputs, int row, int col) {
        int size = 0, curr_row, curr_col;
        Queue<Integer> q_row = new LinkedList<Integer>();
        Queue<Integer> q_col = new LinkedList<Integer>();
        boolean check[][] = new boolean[inputs.length][inputs[row].length()];
        q_row.add(row);
        q_col.add(col);
        check[row][col] = true;
        while (q_row.peek() != null) {
            curr_row = q_row.peek();
            q_row.remove();
            curr_col = q_col.peek();
            q_col.remove();
            if (curr_row + 1 < inputs.length && check[curr_row + 1][curr_col] == false
                    && inputs[curr_row + 1].charAt(curr_col) != '9'
                    && inputs[curr_row].charAt(curr_col) < inputs[curr_row + 1].charAt(curr_col)) {
                q_row.add(curr_row + 1);
                q_col.add(curr_col);
                check[curr_row + 1][curr_col] = true;
            }
            if (curr_row - 1 >= 0 && check[curr_row - 1][curr_col] == false
                    && inputs[curr_row - 1].charAt(curr_col) != '9'
                    && inputs[curr_row].charAt(curr_col) < inputs[curr_row - 1].charAt(curr_col)) {
                q_row.add(curr_row - 1);
                q_col.add(curr_col);
                check[curr_row - 1][curr_col] = true;
            }
            if (curr_col + 1 < inputs[curr_row].length() && check[curr_row][curr_col + 1] == false
                    && inputs[curr_row].charAt(curr_col + 1) != '9'
                    && inputs[curr_row].charAt(curr_col) < inputs[curr_row].charAt(curr_col + 1)) {
                q_row.add(curr_row);
                q_col.add(curr_col + 1);
                check[curr_row][curr_col + 1] = true;
            }
            if (curr_col - 1 >= 0 && check[curr_row][curr_col - 1] == false
                    && inputs[curr_row].charAt(curr_col - 1) != '9'
                    && inputs[curr_row].charAt(curr_col) < inputs[curr_row].charAt(curr_col - 1)) {
                q_row.add(curr_row);
                q_col.add(curr_col - 1);
                check[curr_row][curr_col - 1] = true;
            }
            ++size;
        }
        return size;
    }

    public static void print_array(String[] inputs) {
        for (int i = 0; i < inputs.length; ++i)
            System.out.print(inputs[i] + ' ');
    }

    public static void print_array(ArrayList<Integer> inputs) {
        for (int i = 0; i < inputs.size(); ++i) {
            System.out.print(inputs.get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

    public class pair<F, S> {
        F key;
        S value;

        public pair(F key, S value) // Constructor of the class
        {
            this.key = key;
            this.value = value;
        }

        public F first() {
            return key;
        }

        public S second() {
            return value;
        }
    }
}

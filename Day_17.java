
/* Practice java codingss */
// shift + alt + f for auto indent
import java.util.*;
import java.io.*;
import util.*;

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
            // String input = scanner.next();
            int x_upper = 273, x_lower = 241, y_upper = -97, y_lower = -63, max_height = 0, x_speed = 0, y_speed = 0;
            int temp;
            int[] holder = {0};
            // 200 * 1000 of while loop -> very inefficient
            for (int i = 22; i < 274; ++i) { // 22 is min speed to rch within 241 (artith progression)
                for (int j = -100; j < 1000; ++j) {
                    temp = get_max_height(x_upper, x_lower, y_upper, y_lower, i, j, holder);
                    if (temp > max_height) {
                        max_height = temp;
                        x_speed = i;
                        y_speed = j;
                    }
                }
            }
            System.out.println(x_speed);
            System.out.println(y_speed);
            counter = max_height;
            System.out.println(counter);
            System.out.println(holder[0]);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static int get_max_height(int x_upper, int x_lower, int y_upper, int y_lower, int x_speed, int y_speed, int[] holder) {
        // my brute force on spamming all possible speeds hehe
        int x = 0, y = 0, y_max = 0;
        while (x < x_lower || y > y_lower) {
            if (y_speed >= 0)
                y_max = y;
            x += x_speed;
            y += y_speed;
            if (x_speed != 0)
                --x_speed;
            else if(x < x_lower) break;
            --y_speed;
        }
        if (!(x >= x_lower && y <= y_lower && x <= x_upper && y >= y_upper))
            y_max = -1;
        if(y_max >= 0) ++holder[0];
        return y_max;
    }

    public static void print_stack(Stack<Character> inputs) {
        while (!inputs.empty()) {
            System.out.print(inputs.pop());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void print_array(String[] inputs) {
        for (int i = 0; i < inputs.length; ++i)
            System.out.print(inputs[i] + ' ');
        System.out.println();
    }

    public static void print_array(int[] inputs) {
        for (int i = 0; i < inputs.length; ++i) {
            System.out.print(inputs[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void print_array(long[] inputs) {
        for (int i = 0; i < inputs.length; ++i) {
            System.out.print(inputs[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static <T> void print_array(ArrayList<T> inputs) {
        for (int i = 0; i < inputs.size(); ++i) {
            System.out.print(inputs.get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

    public static <T> void print_2d_array(ArrayList<ArrayList<T>> inputs) {
        for (int i = 0; i < inputs.size(); ++i) {
            for (int j = 0; j < inputs.get(i).size(); ++j) {
                System.out.print(inputs.get(i).get(j));
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print_2d_list(List<List<Node>> inputs) {
        for (int i = 0; i < inputs.size(); ++i) {
            System.out.print(i);
            System.out.print(": ");
            for (int j = 0; j < inputs.get(i).size(); ++j) {
                System.out.print(inputs.get(i).get(j).n);
                System.out.print(',');
                System.out.print(inputs.get(i).get(j).price);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print_matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print_matrix_bounded(int[][] matrix, int row, int col, boolean spacing) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(matrix[i][j]);
                if (spacing)
                    System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fill_matrix(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; ++i) {
            Arrays.fill(matrix[i], value);
        }
    }

    public static void add_to_matrix(int[][] matrix, int adder) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] += 1;
            }
        }
    }

    public static int count_zero_matrix(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[i].length; ++j)
                if (matrix[i][j] == 0)
                    ++counter;
        return counter;
    }

    public static String insert_string(String input, String insert, int index) {
        String newString = input.substring(0, index + 1) + insert + input.substring(index + 1);
        return newString;
    }

    public static int hash_func(String chopchop) {
        int counter = 0;
        for (int i = 0; i < chopchop.length(); ++i) {
            counter *= 26;
            counter += (chopchop.charAt(i) - 'A');
        }
        return counter;
    }
}

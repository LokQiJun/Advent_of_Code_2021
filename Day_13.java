
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
            int counter = 0, x = 0, y = 0;
            String inputs;
            int[][] matrix = new int[1400][1400];
            fill_matrix(matrix, 1);
            while (scanner.hasNext()) {
                inputs = scanner.next();
                if (inputs.equals("fold")) {
                    inputs = scanner.next();
                    inputs = scanner.next();
                    String[] vertex = inputs.split("=");
                    System.out.println(vertex[0] + " = " + vertex[1]);
                    System.out.println(count_zero_matrix(matrix));
                    if (vertex[0].equals("x") ){
                        x = Integer.parseInt(vertex[1]);
                        fold_vertical(matrix, Integer.parseInt(vertex[1]));
                    }
                    else{
                        fold_horizontal(matrix, Integer.parseInt(vertex[1]));
                        x = Integer.parseInt(vertex[1]);
                    }
                } else {
                    String[] vertex = inputs.split(",");
                    x = Integer.parseInt(vertex[0]);
                    y = Integer.parseInt(vertex[1]);
                    matrix[y][x] = 0;
                }
            }

            counter = count_zero_matrix(matrix);
            System.out.println(counter);
            print_matrix_bounded(matrix, x, y, false);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static void fold_horizontal(int[][] matrix, int y) {
        for (int i = y; i < (y * 2) + 1; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[(2 * y) - i][j] = 0;
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = y * 2 + 1; i < matrix.length; ++i)
            for (int j = 0; j < matrix[i].length; ++j)
                matrix[i][j] = 1;
    }

    private static void fold_vertical(int matrix[][], int x) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = x; j < (x * 2) + 1; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][(2 * x) - j] = 0;
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i)
            for (int j = x * 2 + 1; j < matrix[i].length; ++j)
                matrix[i][j] = 1;
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
                if(matrix[i][j] != 0) System.out.print(" ");
                else System.out.print("#");
                if(spacing) System.out.print(' ');
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

    public static int hash_func(String chopchop) {
        int counter = 0;
        for (int i = 0; i < chopchop.length(); ++i) {
            counter *= 26;
            counter += (chopchop.charAt(i) - 'A');
        }
        return counter;
    }
}

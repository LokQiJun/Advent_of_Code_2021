
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
            long counter = 0, x, y, z, num_substr;
            long[] alphabet_freq = new long[26];
            long[] substr_freq = new long[26 * 26];
            Arrays.fill(alphabet_freq, 0);
            Arrays.fill(substr_freq, 0);
            String inputs, inserted, polymer = scanner.next();
            ArrayList<String> substr = new ArrayList<>(), insert = new ArrayList<>();
            ArrayList<Long> updates = new ArrayList<>();
            for (int i = 0; i < polymer.length(); ++i) {
                alphabet_freq[(polymer.charAt(i) - 'A')] += 1;
                if (i < polymer.length() - 1) {
                    inputs = polymer.substring(0 + i, 2 + i);
                    substr_freq[(inputs.charAt(0) - 'A') * 26 + (inputs.charAt(1) - 'A')] += 1;
                }
            }
            while (scanner.hasNext()) {
                inputs = scanner.next();
                scanner.next();
                inserted = scanner.next();
                substr.add(inputs);
                insert.add(inserted);
            }
            z = 10;
            z = 40; // comment for part 1
            for (int i = 0; i < z; ++i) {
                for (int j = 0; j < substr.size(); ++j) {
                    num_substr = substr_freq[(substr.get(j).charAt(0) - 'A') * 26 + (substr.get(j).charAt(1) - 'A')];
                    substr_freq[(substr.get(j).charAt(0) - 'A') * 26 + (substr.get(j).charAt(1) - 'A')] = 0;
                    alphabet_freq[insert.get(j).charAt(0) - 'A'] += num_substr;
                    updates.add(num_substr);
                    updates.add((long)(substr.get(j).charAt(0) - 'A') * 26 + (insert.get(j).charAt(0) - 'A'));
                    updates.add((long)(insert.get(j).charAt(0) - 'A') * 26 + (substr.get(j).charAt(1) - 'A'));
                }
                for (int j = 0; j < updates.size(); j += 3) {
                    substr_freq[updates.get(j+1).intValue()] += updates.get(j);
                    substr_freq[updates.get(j+2).intValue()] += updates.get(j);
                }
                updates.clear();
            }
            //print_array(alphabet_freq);
            //print_array(substr_freq);
            counter = get_diff(alphabet_freq);
            System.out.println(counter);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static long get_diff(long[] freq) {
        long max = freq[0], min = freq[0];
        for (int i = 1; i < freq.length; ++i) {
            if (freq[i] > max)
                max = freq[i];
            if (min == 0 || (freq[i] != 0 && freq[i] < min))
                min = freq[i];
        }
        return max - min;
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

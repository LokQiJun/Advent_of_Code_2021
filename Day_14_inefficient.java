
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
            int counter = 0, x, y, z;
            int[] alphabet_freq = new int[26];
            int[] substr_freq = new int[26*26 + 1];
            Arrays.fill(alphabet_freq, 0);
            Arrays.fill(substr_freq, 0);
            String inputs, inserted, polymer = scanner.next();
            ArrayList<String> substr = new ArrayList<>(), insert = new ArrayList<>();
            for(int i = 0; i < polymer.length(); ++i){
                alphabet_freq[ (polymer.charAt(i) - 'A') ] += 1;
                if(i < polymer.length() - 1){
                    inputs = polymer.substring(0+i, 2+i);
                    substr_freq[(inputs.charAt(0) - 'A') * 26 + (inputs.charAt(1) - 'A')] += 1;
                }
            }
            while (scanner.hasNext()) {
                inputs = scanner.next();
                scanner.next();
                inserted = scanner.next();
                substr.add(inputs); // can optimise by hashing based on first letter (26 arraylist)
                insert.add(inserted);
            }
            z = 10;
            //z = 40; // comment for part 1
            for(int i = 0; i < z; ++i){ // part 2 might run longer since checksubstr is not optimised yet
                x = polymer.length() - 1;
                for(int j = 0; j < x; ++j){
                    y = check_substr(polymer.substring(0+j, 2+j) , substr);
                    if(y != -1){
                        polymer = insert_string(polymer, insert.get(y), j);
                        alphabet_freq[insert.get(y).charAt(0) - 'A'] += 1;
                        j += 1;
                        ++x;
                    }
                }
            }
            System.out.println(polymer.length());
            print_array(alphabet_freq);
            counter = get_diff(alphabet_freq);
            System.out.println(counter);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }
    
    private static int get_diff(int[]freq){
        int max = freq[0], min = freq[0];
        for(int i = 1; i < freq.length; ++i){
            if(freq[i] > max) max = freq[i];
            if(min == 0 || (freq[i] != 0 && freq[i] < min)) min = freq[i];
        }
        return max - min;
    }

    private static int check_substr(String substr, ArrayList<String> inputs){
        for(int i = 0; i < inputs.size(); ++i){
            if(substr.equals(inputs.get(i))) return i;
        }
        return -1;
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
                System.out.print(matrix[i][j]);
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

    public static String insert_string(String input, String insert, int index){
        String newString = input.substring(0, index+1) + insert + input.substring(index+1);
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


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
            int timer = 0;
            String inputs;
            int[][] matrix = new int[10][10];
            for(int i = 0; i < 10; ++i){
                inputs = scanner.nextLine();
                for(int j = 0; j < 10; ++j){
                    matrix[i][j] = inputs.charAt(j) - '0';
                }
            }
            print_matrix(matrix);
            while(true){
                add_to_matrix(matrix, 1);
                update_flashing(matrix);
                //print_matrix(matrix);
                if(timer < 100)counter += count_zero_matrix(matrix);
                ++timer;
                if(count_zero_matrix(matrix) == matrix.length * matrix[0].length) break;
            }
            System.out.println(counter); // part 1 ans
            System.out.println(timer); // part 2 ans
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    public static void print_stack(Stack<Character> inputs){
        while(!inputs.empty()){
            System.out.print(inputs.pop());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void print_array(String[] inputs) {
        for (int i = 0; i < inputs.length; ++i)
            System.out.print(inputs[i] + ' ');
    }

    public static <T> void print_array(ArrayList<T> inputs) {
        for (int i = 0; i < inputs.size(); ++i) {
            System.out.print(inputs.get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void print_matrix(int[][] matrix){
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void add_to_matrix(int[][] matrix, int adder){
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                matrix[i][j] += 1;
            }
        }
    }

    private static void update_flashing(int[][]matrix){
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                if(matrix[i][j] > 9) surrounding_add_matrix(matrix, i, j);
            }
        }
    }

    private static void surrounding_add_matrix(int[][] matrix, int row, int col){
        matrix[row][col] = 0;
        for(int i = row - 1; i <= row + 1; ++i){
            for(int j = col - 1; j <= col + 1; ++j){
                if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length){
                    if(matrix[i][j] != 0) matrix[i][j] += 1;
                    if(matrix[i][j] > 9) surrounding_add_matrix(matrix, i, j);
                }
            }
        }
    }

    public static int count_zero_matrix(int[][] matrix){
        int counter = 0;
        for(int i = 0; i < matrix.length; ++i)
            for(int j = 0; j < matrix[i].length; ++j)
                if(matrix[i][j] == 0) ++counter;
        return counter;
    }
}

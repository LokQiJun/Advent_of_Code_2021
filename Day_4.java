/* Practice java codingss */

import java.util.*;
import java.io.*;

public class coding {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
        try {
            // Scanner scanner = new Scanner(System.in); // uncomment when submitting
            // * comment this whole section when submitting
            File in = new File("in.txt");
            Scanner scanner = new Scanner(in);
            PrintStream out = new PrintStream("out.txt");
            PrintStream err = new PrintStream("err.txt");
            System.setOut(out);
            System.setErr(err);
            // */
            String inputs;
            int[] input = new int[100];
            int[][] bingo = new int[5][5];
            int steps = 0; long sum = 0; // set steps to any int > 100 for part 1
            boolean flag = false, check = false; // flag to indicate bingo num is found, check to indicate bingo alrdy achieved
            // scanner.useDelimiter("[,\\s+]");
            inputs = scanner.nextLine();
            String[] numbers = inputs.split(",");
            for (int i = 0; i < 100; ++i) {
                input[i] = Integer.parseInt(numbers[i]);
            }
            while (scanner.hasNext()) {
                inputs = scanner.nextLine();
                for (int i = 0; i < 5; ++i) {
                    inputs = scanner.nextLine();
                    //System.out.println(inputs);
                    for(int j = 0; j < 5; ++j){
                        if(inputs.charAt(0 + 3 * j) == ' ') bingo[i][j] = Integer.parseInt(inputs.substring(1 + 3 * j, 2 + 3 * j));
                        else bingo[i][j] = Integer.parseInt(inputs.substring(0 + 3 * j, 2 + 3 * j));
                        //System.out.println(inputs.substring(0 + 3 * j, 2 + 3 * j));
                    }
                }
                for(int i = 0; i < 100; ++i){
                    for(int j = 0; j < 5; ++j){
                        for(int k = 0; k < 5; ++k){
                            if(bingo[j][k] == input[i]){
                                bingo[j][k] = -1;
                                if(check_bingo(j, k, bingo)){
                                    //if(i < steps) { //uncomment for part 1
                                    if(i > steps) { //comment for part 1
                                        sum = cal_product(bingo) * input[i];
                                        steps = i;
                                        System.out.println(i);
                                        System.out.println(sum);
                                        print_bingo(bingo); // for debugging
                                    }
                                    check = true;
                                }
                                flag = true;
                                break;
                            }
                        }
                        if(flag == true){
                            flag = false; break;
                        }
                    }
                    if(check == true){
                        check = false; break;
                    }
                }
            }
            System.out.println(steps);
            System.out.println(sum);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static Boolean check_bingo(int row, int column, int[][] bingo) {
        Boolean flag_row = true, flag_column = true;
        for (int i = 0; i < 5; ++i) {
            if (bingo[row][i] != -1)
                flag_row = false;
            if (bingo[i][column] != -1)
                flag_column = false;
        }
        return flag_row || flag_column;
    }

    private static long cal_product(int[][] bingo){
        long sum = 0;
        for(int i = 0; i < 5; ++i)
            for(int j = 0; j < 5; ++j)
                if(bingo[i][j] != -1) sum += bingo[i][j];
        return sum;
    }

    private static void print_bingo(int[][] bingo){
        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < 5; ++j) {
                System.out.print(bingo[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
}

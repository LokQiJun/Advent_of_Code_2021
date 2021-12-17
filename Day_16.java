
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
            String input = scanner.next();
            String binary = hexToBinary(input);
            ArrayList<Integer> versions = new ArrayList<>();
            ArrayList<Long> store_digits = new ArrayList<>(); // can be stack or queue as well just need to mind ordering for compare
            loop_thru_binary(versions, binary, 0, store_digits);
            //System.out.println(binary);
            for(int i = 0; i < versions.size(); ++i){
                counter += versions.get(i);
            }
            System.out.println(counter); //part 1
            System.out.println(store_digits.size());
            System.out.println(store_digits.get(0)); //part 2
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static int loop_thru_binary(ArrayList<Integer> versions, String binary, int index, ArrayList<Long> storage){
        versions.add(Integer.parseInt(binary.substring(index, index+3), 2));
        index += 3;
        int type = Integer.parseInt(binary.substring(index, index+3), 2);
        index += 3;
        String temp = "";
        if(type == 4){
            while(binary.charAt(index) == '1'){
                ++index;
                temp += binary.substring(index, index + 4);
                index += 4;
            }
            ++index;
            temp += binary.substring(index, index + 4);
            index += 4;
            long digit = Long.parseLong(temp, 2);
            System.out.print("4: "); System.out.println(digit);
            storage.add(digit);
            temp = "";
        }
        else{ 
            // no need to go till end since behind is padded with 0s
            // no need to check for out of bounds since qn guaranteed is within range so outofbounds is due to bugs
            ArrayList<Long> store_digits = new ArrayList<>();
            long counter = 0;
            if(binary.charAt(index) == '0'){
                ++index;
                int length = Integer.parseInt(binary.substring(index, index + 15), 2);
                index += 15;
                int holder = index;
                while(index != holder + length){
                index = loop_thru_binary(versions, binary, index, store_digits);
                }
            }
            else{
                ++index;
                int num_sub = Integer.parseInt(binary.substring(index, index + 11), 2);
                index += 11;
                for(int i = 0; i < num_sub; ++i){
                    index = loop_thru_binary(versions, binary, index, store_digits);
                }
            }
            System.out.print(type); System.out.print(": "); print_array(store_digits);
            if(type == 0){ //sum
                for(int i = 0; i < store_digits.size(); ++i){
                    counter += store_digits.get(i);
                }
                storage.add(counter);
            }
            else if(type == 1){ //product
                counter = 1;
                for(int i = 0; i < store_digits.size(); ++i){
                    counter *= store_digits.get(i);
                }
                storage.add(counter);
            }
            else if(type == 2){ //min
                counter = store_digits.get(0);
                for(int i = 1; i < store_digits.size(); ++i){
                    if(store_digits.get(i) < counter) counter = store_digits.get(i);
                }
                storage.add(counter);
            }
            else if(type == 3){ //max
                counter = store_digits.get(0);
                for(int i = 1; i < store_digits.size(); ++i){
                    if(store_digits.get(i) > counter) counter = store_digits.get(i);
                }
                storage.add(counter);
            }
            else if(type == 5){ // greater than
                if(store_digits.get(0) > store_digits.get(1)) counter = 1;
                storage.add(counter);
            }
            else if(type == 6){ // lesser than
                if(store_digits.get(0) < store_digits.get(1)) counter = 1;
                storage.add(counter);
            }
            else if(type == 7){ // equals to
                if((long)store_digits.get(0) == (long)store_digits.get(1)) counter = 1;
                storage.add(counter);
            }
        }
        return index;
    }

    public static String hexToBinary(String hex) {
        String binary = "";
        hex = hex.toUpperCase();

        HashMap<Character, String> hashMap = new HashMap<Character, String>();
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");
 
        int i;
        char ch;
 
        for (i = 0; i < hex.length(); i++) {
            ch = hex.charAt(i);
            if (hashMap.containsKey(ch))
                binary += hashMap.get(ch);
            else {
                binary = "Invalid Hexadecimal String";
                return binary;
            }
        }
        return binary;
    }

    /* 
    1st 3 bit: packet ver
    next 3 bit: packet id
    if id is 4 (100) , then its literal value
    literal value :
    in groups of 5 bit: header_4bitvalue (if header == 1, repeatedly add in grps of 5, else terminate)
    add all all the 4 bits into one long chain and convert tat to decimal

    */
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

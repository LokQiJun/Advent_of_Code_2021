
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
            int counter = 0, x, y, z, curr_index;
            ArrayList<String> risk_matrix = new ArrayList<>();
            while (scanner.hasNext()) {
                risk_matrix.add(scanner.next());
            }
            int total_vertex = risk_matrix.size() * risk_matrix.get(0).length();
            List<List<Node>> adjacent = new ArrayList<List<Node>>();
            for (int i = 0; i < total_vertex; i++) {
                List<util.Node> itm = new ArrayList<Node>();
                adjacent.add(itm);
            }
            for (int i = 0; i < risk_matrix.size(); ++i) {
                for (int j = 0; j < risk_matrix.get(0).length(); ++j) {
                    curr_index = j + i * risk_matrix.get(i).length();
                    if (curr_index % risk_matrix.get(i).length() != risk_matrix.get(i).length() - 1) {
                        x = Character.getNumericValue(risk_matrix.get(i).charAt(j + 1));
                        adjacent.get(curr_index).add(new Node(curr_index + 1, x));
                    }
                    if (curr_index % risk_matrix.get(i).length() != 0) {
                        x = Character.getNumericValue(risk_matrix.get(i).charAt(j - 1));
                        adjacent.get(curr_index).add(new Node(curr_index - 1, x));
                    }
                    if (i != risk_matrix.size() - 1) {
                        y = Character.getNumericValue(risk_matrix.get(i + 1).charAt(j));
                        adjacent.get(curr_index).add(new Node(curr_index + risk_matrix.get(i).length(), y));
                    }
                    if (i != 0) {
                        y = Character.getNumericValue(risk_matrix.get(i - 1).charAt(j));
                        adjacent.get(curr_index).add(new Node(curr_index - risk_matrix.get(i).length(), y));
                    }
                }
            }
            // print_2d_list(adjacent);
            Dijkstra obj = new Dijkstra(total_vertex);
            obj.dijkstra(adjacent, 0);
            counter = obj.get_distance(total_vertex - 1);
            System.out.println(counter);

            //part 2
            ArrayList<String> risk_matrix_larger = new ArrayList<>();
            for (int j = 0; j < 5; ++j) {
                for (int i = 0; i < risk_matrix.size(); ++i) {
                    risk_matrix_larger.add(get_full(risk_matrix.get(i)));
                    risk_matrix.set(i, up_one(risk_matrix.get(i)));
                }
            }
            total_vertex = risk_matrix_larger.size() * risk_matrix_larger.get(0).length();
            adjacent.clear();
            for (int i = 0; i < total_vertex; i++) {
                List<util.Node> itm = new ArrayList<Node>();
                adjacent.add(itm);
            }
            for (int i = 0; i < risk_matrix_larger.size(); ++i) {
                for (int j = 0; j < risk_matrix_larger.get(0).length(); ++j) {
                    curr_index = j + i * risk_matrix_larger.get(i).length();
                    if (curr_index % risk_matrix_larger.get(i).length() != risk_matrix_larger.get(i).length() - 1) {
                        x = Character.getNumericValue(risk_matrix_larger.get(i).charAt(j + 1));
                        adjacent.get(curr_index).add(new Node(curr_index + 1, x));
                    }
                    if (curr_index % risk_matrix_larger.get(i).length() != 0) {
                        x = Character.getNumericValue(risk_matrix_larger.get(i).charAt(j - 1));
                        adjacent.get(curr_index).add(new Node(curr_index - 1, x));
                    }
                    if (i != risk_matrix_larger.size() - 1) {
                        y = Character.getNumericValue(risk_matrix_larger.get(i + 1).charAt(j));
                        adjacent.get(curr_index).add(new Node(curr_index + risk_matrix_larger.get(i).length(), y));
                    }
                    if (i != 0) {
                        y = Character.getNumericValue(risk_matrix_larger.get(i - 1).charAt(j));
                        adjacent.get(curr_index).add(new Node(curr_index - risk_matrix_larger.get(i).length(), y));
                    }
                }
            }
            Dijkstra objs = new Dijkstra(total_vertex);
            objs.dijkstra(adjacent, 0);
            counter = objs.get_distance(total_vertex-1);
            System.out.println(counter);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static String get_full(String input){
        String output = input, temp = "", holder = input;
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < input.length(); ++j){
                if(holder.charAt(j) != '9') temp = temp + (char)(holder.charAt(j) + 1); 
                else temp = temp + '1';
            }
            //System.out.println(temp);
            output += temp; holder = temp; temp = "";
        }
        return output;
    }

    private static String up_one(String input) {
        String temp = "";
            for(int j = 0; j < input.length(); ++j){
                if(input.charAt(j) != '9') temp = temp + (char)(input.charAt(j) + 1); 
                else temp = temp + '1';
            }
        return temp;
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

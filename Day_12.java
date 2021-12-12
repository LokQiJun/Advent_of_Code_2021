
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
            int counter = 0, start, end;
            String inputs;
            ArrayList<String> first = new ArrayList<>(), second = new ArrayList<>(),
                    all = new ArrayList<>();
            while (scanner.hasNext()) {
                inputs = scanner.nextLine();
                String[] vertex = inputs.split("-");
                first.add(vertex[0]);
                second.add(vertex[1]);
                all.add(vertex[0]);
                all.add(vertex[1]);
            }

            // to remove duplicate
            Set<String> set = new HashSet<>(all);
            all.clear();
            all.addAll(set);
            int size = all.size(); // num of vertex

            // sorting out index and populating al
            ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>(size);
            for (int i = 0; i < size; i++)
                al.add(new ArrayList<Integer>());
            int[] visited = new int[size];
            Arrays.fill(visited, 0);
            Collections.swap(all, all.indexOf("start"), 0);
            Collections.swap(all, all.indexOf("end"), size - 1);
            //print_array(first); print_array(second); print_array(all);
            for (int i = 0; i < first.size(); ++i) {
                start = all.indexOf(first.get(i)); //System.out.print(start);
                end = all.indexOf(second.get(i)); //System.out.print(" " + end + "\n");
                al.get(start).add(end);
                al.get(end).add(start);
            }

            //print_2d_array(al);
            counter = countPaths(al, 0, size-1, visited, all);

            System.out.println(counter); // part 1 ans
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }

    private static int countPathsUtil(ArrayList<ArrayList<Integer>> al, int u, int d, int pathCount, int[] visited, ArrayList<String> all, boolean twice_smol_cave) {
        char k = all.get(u).charAt(0);
        if(!Character.isUpperCase(k)) visited[u] += 1; // add visit count
        if (u == d) { // If current vertex is same as destination, then increment count
            pathCount++;
        }

        else { // Recur for all the vertices adjacent to this vertex
            for(int i = 0; i < al.get(u).size(); ++i){
                int n = al.get(u).get(i);
                //if(visited[n] < 1) //uncomment for part 1
                if(visited[n] == 0) //comment for part 1
                    pathCount = countPathsUtil(al, n, d, pathCount, visited, all, twice_smol_cave);
                else if(n != 0 && !twice_smol_cave && visited[n] == 1) // when has not visit a small cave twice and the cave now is visited once
                    pathCount = countPathsUtil(al, n, d, pathCount, visited, all, true);
            }
        }
        if(!Character.isUpperCase(k)) visited[u] -= 1;
        return pathCount;
    }

    private static int countPaths(ArrayList<ArrayList<Integer>> al, int s, int d, int[] visited, ArrayList<String> all) {
        int pathCount = countPathsUtil(al, s, d, 0, visited, all, false);
        return pathCount;
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

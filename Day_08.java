
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
            int counter = 0, digit1, digit2, digit3, digit4;
            String inputs;
            String[] patterns = new String[10];
            String[] outputs = new String[4];
            while(scanner.hasNext()){
                for(int i = 0; i < 10; ++i){
                    inputs = scanner.next();
                    patterns[i] = sort_alphabetically(inputs);
                }
                Arrays.sort(patterns, Comparator.comparingInt(String::length)); // sort by length(num of seg)
                // lengths: 2, 3, 4, 5, 5, 5, 6, 6, 6, 7
                //print_array(patterns);
                inputs = scanner.next();
                for(int i = 0; i < 4; ++i){
                    inputs = scanner.next();
                    outputs[i] = sort_alphabetically(inputs);
                    counter += (get_digit(patterns, outputs[i]) * Math.pow(10, 3-i));
                }
            }
            System.out.println(counter);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("sORT ME oUt");
        }
    }
    
    private static int get_digit(String[] patterns, String input){
        if(input.length() == 2) return 1;
        if(input.length() == 3) return 7;
        if(input.length() == 4) return 4;
        if(input.length() == 7) return 8;
        if(input.length() == 5) {
            if(contains(input, patterns[0])) return 3;
            if(contains(patterns[6], input) && contains(patterns[7], input)) return 5;
            if(contains(patterns[7], input) && contains(patterns[8], input)) return 5;
            if(contains(patterns[6], input) && contains(patterns[8], input)) return 5;
            return 2;
        }
        if(input.length() == 6) {
            if(contains(input, patterns[2])) return 9;
            if(contains(input, patterns[0])) return 0;
            return 6;
        }
        return -1; // counter *= so will show negative if thrs a mistake (unless even no. of mistakes occuring)
    }

    private static Boolean contains(String input, String comparison){
        int j = 0;
        for(int i = 0; i < comparison.length(); ++i){
            while(j < input.length() && comparison.charAt(i) != input.charAt(j)) ++j;
            if(j == input.length() ) return false;  
        }
        return true;
    }

    public static String sort_alphabetically(String temp){
      char[] ch = temp.toCharArray();
      // sorting char array
      Arrays.sort(ch);
      // converting char array to string
      return String.valueOf(ch);
   }

   public static void print_array(String[] inputs){
       for(int i = 0; i < inputs.length; ++i) System.out.print(inputs[i] + ' ');
   }
}

/* 
1, 4, 7, 8 is unique
if 6 seg && contains seg_4 : its 0 (the center horizontal)
else if 6 seg && contains seg_7 : its 9 (the btm rigt vertical)
else its 6 (the only option left for 6 seg)
if 5 seg && contains seg_1 : its 3 (the 2 rightmost vertical)
else if 5 seg && seg_6 contains && seg_9 contains : its 5 (no way to find which 2 among 3 6-seg value is 6 and 9 so just code all 3 possibility(ab, bc, ac) )
else its 2


0: 6 seg (all but center horizontal)
1: 2 seg (2 rightmost)
2: 5 seg (all 3 horizontal and top right + btm left vertical)
3: 5 seg (1 + all horizontal)
4: 4 seg (1 + middle center + top left vertical)
5: 5 seg (all 3 horizontal and top left + btm right vertical)
6: 6 seg (all but top right vertical)
7: 3 seg (1 + top)
8: all 7 seg
9: 6 seg (all but btm left vertical)
*/
